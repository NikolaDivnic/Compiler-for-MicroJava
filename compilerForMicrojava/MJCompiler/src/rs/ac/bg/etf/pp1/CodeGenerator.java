package rs.ac.bg.etf.pp1;



import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
public class CodeGenerator extends VisitorAdaptor {

	private int mainPc;
	private LinkedList<Integer> listaOperacija = new LinkedList();
	boolean fleg = false;
	boolean imaMinus = false;
	private LinkedList<Integer> zagrade = new LinkedList();
	private LinkedList<Integer> mnozenje = new LinkedList();
	int brojac= 0;
	public int getMainPc(){
		return mainPc;
	}
	public void visit(PrintStatement printStmt){
		
		racunaj();
		
		
		if (printStmt.getPrintExpr() instanceof HaveExpr) {
			Code.loadConst(((HaveExpr)printStmt.getPrintExpr()).getPrintWidth().getN1());
			if (((HaveExpr)printStmt.getPrintExpr()).getPrintWidth().getN1() == 1) {
				Code.put(Code.bprint);
			}
			else {
				Code.put(Code.print);
			}
		}
		else 
		if(printStmt.getExpr().obj.getType() == Tab.intType){
			Code.loadConst(5);
			Code.put(Code.print);
		}else{
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}
	
	public void visit(FactorCharConst cnst){
		Obj con = Tab.insert(Obj.Con, "$", cnst.obj.getType());
		con.setLevel(0);
		con.setAdr(cnst.getC1());
		Code.load(con);	
		
		
	}
	
	boolean noviFleg = false;
	
	public void visit(FactorDesignatorNoParam factorDesignatorNoParam) {
	
		Code.load(factorDesignatorNoParam.getDesignator().obj);
		if(noviFleg == false) {
			if ( listaOperacija.size()>0) {
				
				int op = listaOperacija.getLast();
				if (op == -1) {
					return;
				}
				if ( op == Code.mul || op ==  Code.div || op == Code.rem) {
					Code.put(listaOperacija.removeLast());
					brojac--;
				}			
			}
		}
		
		noviFleg = false;
	}
	public void visit(FactorBoolConst cnst){
		Obj con = Tab.insert(Obj.Con, "$", cnst.obj.getType());
		con.setLevel(0);
		int boolValue  = 0;
		if(cnst.getB1().equals("true")) boolValue = 1;
		con.setAdr(boolValue);
		
		Code.load(con);
		
	}
	
	public void visit(FactorNumConst cnst){
		Obj con = Tab.insert(Obj.Con, "$", cnst.obj.getType());
		con.setLevel(0);
		con.setAdr(cnst.getN1());
		
		Code.load(con);
		if(noviFleg == false) {
			if ( listaOperacija.size()>0) {
				
				int op = listaOperacija.getLast();
				if (op == -1) {
					return;
				}
				if ( op == Code.mul || op ==  Code.div || op == Code.rem) {
					Code.put(listaOperacija.removeLast());
					brojac--;
				}			
			}
		}
		
		noviFleg = false;
	}
	
	public void visit(CharConstDecl cnst){
		Obj con = Tab.insert(Obj.Con, "$", cnst.struct);
		con.setLevel(0);
		con.setAdr(cnst.getC1());
		Code.load(con);
	}
	public void visit(BoolConstDecl cnst){
		Obj con = Tab.insert(Obj.Con, "$", cnst.struct);
		con.setLevel(0);
		
		int boolValue  = 0;
		if(cnst.getB1().equals("true")) boolValue = 1;
		con.setAdr(boolValue);
		Code.load(con);
	}
	public void visit(NumConstDecl cnst){
		Obj con = Tab.insert(Obj.Con, "$", cnst.struct);
		con.setLevel(0);
		con.setAdr(cnst.getN1());
		Code.load(con);
	}
	
	public void visit(MethodName methodTypeName){
		if("main".equalsIgnoreCase(methodTypeName.getMethodName())){
			mainPc = Code.pc;
		}
		
		methodTypeName.obj.setAdr(Code.pc);
		
		Code.put(Code.enter);
		Code.put(methodTypeName.obj.getLevel());
		Code.put(methodTypeName.obj.getLocalSymbols().size());
		
	}
	
	public void visit(MethodDeclaration methodDecl){
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(AddopPlus term){
		listaOperacija.add(Code.add);
		brojac++;
	}
	
	public void visit(AddopMinus term){	
		listaOperacija.add(Code.add);
		brojac+=2;
		Code.loadConst(-1);
		
		listaOperacija.add(Code.mul);
	}
	public void visit(Neg term){	
		brojac+=1;
		Code.loadConst(-1);
		listaOperacija.add(Code.mul);
	}
	
	public void visit(MulopMultiply term){
		listaOperacija.add(Code.mul);
		brojac++;
	}
	
	public void visit(MulopDevide term){
		listaOperacija.add(Code.div);
		brojac++;
	}
	
	public void visit(MulopModulo term){
		listaOperacija.add(Code.rem);
		brojac++;
	}
	
	public void visit(ParanthesesBegin term){
		listaOperacija.add(-1);
		zagrade.add(brojac);
		
	}
	
	public void visit(ParanthesesEnd term){
		racunaj();
	}
	public void racunaj() {
		if (zagrade.size()>0) {
			int i = zagrade.removeLast();
			while (brojac > i && listaOperacija.size() >0) {
				int stavi = listaOperacija.removeLast();
				if (stavi != -1) {
					brojac--;
					if (stavi == Code.sub) {
						Code.loadConst(-1);
						Code.put(Code.mul);
						Code.put(Code.add);
					}
					else {
						Code.put(stavi);
					}
				}
				
			}
			if ( listaOperacija.size()>0) {
				
				int op = listaOperacija.getLast();
				if (op == -1 && listaOperacija.size()>0) {
					listaOperacija.removeLast();
					if (listaOperacija.size()>0)op = listaOperacija.getLast();
				}
				if ( op == Code.mul || op ==  Code.div || op == Code.rem) {
					brojac--;
					Code.put(listaOperacija.removeLast());
				}
				
			}
			
		}
		else {
			while(listaOperacija.size() > 0) {
				int stavi = listaOperacija.removeLast();
				if (stavi != -1) {
					if (stavi == Code.sub) {
						Code.loadConst(-1);
						Code.put(Code.mul);
						Code.put(Code.add);
					}
					else {
						Code.put(stavi);
					}
				}
			}
		}
		
	}
	public void visit(AssignopExpr expression) {
		racunaj();
		
		Code.store(expression.getDesignator().obj);
		
	}
	/*public void visit(ConstDeclDecl expression) {
		racunaj();
		
		Code.store(expression.getI2());
		
	}*/
	
	
	
	
	public void visit(DesignatorStatIncrement inc) {
		Code.load(inc.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		//Code.loadConst(5);
		Code.store(inc.getDesignator().obj);
		
		
		
		
	}

	public void visit(DesignatorStatDecrement inc) {
		Code.load(inc.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		//Code.loadConst(5);
		Code.store(inc.getDesignator().obj);
		
	}
	
	public void visit(FactorNewExpr newExpr) {
		
		Code.put(Code.newarray);
		/*if (newExpr.getType().obj.getType().getKind() == Struct.Int || newExpr.getType().obj.getType().getKind() == Struct.Bool) {
            Code.put(1);
        } else {
            Code.put(0);
        }*/
		Code.put(1);
		
	}
	Logger log = Logger.getLogger(getClass());
	
	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	public HashMap<String, Integer> labele = new HashMap<>();
	public HashMap<String, LinkedList<Integer>> cekaLabelu = new HashMap<>();
	public void visit(Label l) {
		if (l.getParent() instanceof StatementWithLabel) {
			labele.put(l.getLabel(), Code.pc);
		//	report_info("PC labela  " + Code.pc  , l);

			if (cekaLabelu.containsKey(l.getLabel())) {
				LinkedList<Integer> lista = cekaLabelu.get(l.getLabel());
				for (Integer integer : lista) {
				//	report_info("PC labela  " + integer + "   " + Code.pc  , l);
					Code.fixup(integer);
				}
	        }
			//report_info("PC labela" + Code.pc, l);
		}
		
		
	}
	
	public void visit(GoToStatement designator) {
		//report_info("PC goto" + Code.pc, designator);
		if (labele.get(designator.getLabel().getLabel())!=null)
			Code.putJump(labele.get(designator.getLabel().getLabel()) );
		else {
			
			if (!cekaLabelu.containsKey(designator.getLabel().getLabel())) {
				cekaLabelu.put(designator.getLabel().getLabel(), new LinkedList<>());
	        }
			//report_info("PC goto  " + Code.pc + "   " +designator.getLabel().getLabel() , designator);
			Code.put(Code.jmp);
			
			cekaLabelu.get(designator.getLabel().getLabel()).add(Code.pc);
			Code.put2(0);
		}
	}
	
	
	public void visit(ReadStatement readStetment) {
		
		Struct readS = readStetment.getDesignator().obj.getType();
		if (readStetment.getDesignator().obj.getType().getElemType() != null) {
			readS = readStetment.getDesignator().obj.getType().getElemType();
		}
		
		if ( readS== Tab.intType) {
			Code.put(Code.read);
		}
		else {
			Code.put(Code.bread);
		}
		
		Code.store(readStetment.getDesignator().obj);
		
	}
	

	public void visit(DesNameDecl designator) {
		noviFleg = true;
		//if (designator.getParent() instanceof ArrayElementAccessDesignator) {
			Code.load(designator.obj);
		//}
	}
	
	public void visit(WrepperDecl designator) {
		
		racunaj();
	}
	
	/*public void visit(CaretDecl caret) {
		Code.load(caret.getDesignator().obj);
		//Code.loadConst(caret.getN2());arr ^ 4
		//Code.put(Code.store_1); // constanta
		
		Code.put(Code.store_2); // adr
		
		Code.loadConst(0);
		Code.put(Code.store_3); //i 
		
		Code.put(Code.load_2);
		Code.put(Code.arraylength);
		Code.put(Code.store_1);//store_4 duzina
		
		int preProvere = Code.pc;

		Code.put(Code.load_3);
		Code.put(Code.load_1);
		Code.put(Code.jcc + Code.ge);
		int whileImanjeODLen = Code.pc;
		Code.put2(0);
		
		Code.put(Code.load_2);
		Code.put(Code.load_3);
		Code.put(Code.dup2);
		Code.put(Code.aload);
		Code.loadConst(caret.getN2());
		Code.put(Code.mul);
		Code.put(Code.astore);
		
		Code.put(Code.load_3);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.put(Code.store_3);
		
		
		Code.put(Code.jmp);
		Code.put2(preProvere - (Code.pc - 1));
		
		Code.fixup(whileImanjeODLen);
		
		
	}*/
}
