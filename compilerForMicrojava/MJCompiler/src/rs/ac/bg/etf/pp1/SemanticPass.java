package rs.ac.bg.etf.pp1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticPass extends VisitorAdaptor {
	Obj currentProgram;
	int nVars;
	Logger log = Logger.getLogger(getClass());
	boolean errorDetected = false;
	
	private Struct currentType;
	
	List<Obj> stack = new LinkedList<Obj>(); 
	private Obj method;
	
	String nazivTipa = "";
	
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}
	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	public boolean passed(){
    	return !errorDetected;
    }
	public void visit(ProgName progName) {
		Tab.insert(Obj.Type, "bool", new Struct(Struct.Bool));
		String name = progName.getI1();
		currentProgram = Tab.insert(Obj.Prog, name, Tab.noType);
		Tab.openScope();
	}
	public void visit(Program Program) {
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(currentProgram);
		Tab.closeScope();
	}
	
	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getTypeName());
		currentType = Tab.noType;
		nazivTipa = "void";
    	if(typeNode == Tab.noObj){
    		report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", type);
    		type.struct = Tab.noType;
    	}else{
    		if(Obj.Type == typeNode.getKind()){
    			nazivTipa = type.getTypeName();
    			currentType = typeNode.getType();
    		}else{
    			report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
    			type.struct = Tab.noType;
    		}
    	}
    	type.struct = currentType;
	}
	
	int vrednost_konstante = 0;
	
	
	public void visit(NumConstDecl numConstDecl) {
		numConstDecl.struct = Tab.intType;
		vrednost_konstante = numConstDecl.getN1();
	}
	
	public void visit(CharConstDecl charConstDecl) {
		charConstDecl.struct = Tab.charType;
		vrednost_konstante = charConstDecl.getC1();
	}
	public void visit(BoolConstDecl boolConstDecl) {
		boolConstDecl.struct = Tab.find("bool").getType();
		vrednost_konstante = boolConstDecl.getB1();
	}
	

	/*public void visit(ConstDeclDecl constDeclDecl) {
		if(currentType != constDeclDecl.getConstDeclAfterAssign().struct) {
			report_error("Los tip "+nazivTipa +"    " +constDeclDecl.getI2(), constDeclDecl);
		}
		Tab.insert(Obj.Var,constDeclDecl.getI2(), currentType);
	}
	
	
*/
	public void visit(ConstDeclDecl constDec) {
		
		if(!(constDec.getConstDeclAfterAssign().struct == currentType)) {
			report_error("Los tip", constDec);
		}
		else if(!Tab.find(constDec.getI2()).equals(Tab.noObj)) {
			report_error("vec postoji konstanta", constDec);
		} else {
			Obj constObj = Tab.insert(Obj.Con, constDec.getI2(), currentType);
			constObj.setAdr(vrednost_konstante);
			
		}
		
	}
	
	public void visit(ConstDeclListSingleDecl constDec) {
		
		if(!(constDec.getConstDeclAfterAssign().struct == currentType)) {
			report_error("Los tip", constDec);
		}
		else if(!Tab.find(constDec.getI1()).equals(Tab.noObj)) {
			report_error("vec postoji konstanta", constDec);
		} else {
			Obj constObj = Tab.insert(Obj.Con, constDec.getI1(), currentType);
			constObj.setAdr(vrednost_konstante);
			
		}
		
	}

	
	
	public void visit(VarHaveBracket varHaveBracket) {
		String name = varHaveBracket.getI1();
		Struct type = currentType;
		if(Tab.currentScope.findSymbol(name) != null) {
			report_error("Deklarisana promenljiva "+ varHaveBracket.getI1(), varHaveBracket);
		}
		
		Tab.insert(Obj.Var, name, new Struct(Struct.Array, type));
		
	}
	
	public void visit(VarNotHaveBracket varNotHaveBracket) {
		String name = varNotHaveBracket.getI1();
		Struct type = currentType;
		if(Tab.currentScope.findSymbol(name) != null) {
			report_error("Deklarisana promenljiva "+ varNotHaveBracket.getI1(), varNotHaveBracket);
		}
		Tab.insert(Obj.Var, name, type);
		
	}
	
	
	
	
	
	
	
	public void visit(MethodDeclarationsVoid methodDeclarationsVoid) {
		currentType = Tab.noType;
		
	}
	
	
	public void visit(MethodName methodName) {
		String name = methodName.getMethodName();
		if(Tab.currentScope.findSymbol(name) != null) {
			report_error("Deklarisana metode "+ methodName.getMethodName(), methodName);
		}
		else if (name.equals("main") && currentType != Tab.noType) {
			report_error("Los main " +nazivTipa + "    "+ methodName.getMethodName(), methodName);
			
		}
		else {
			method = Tab.insert(Obj.Meth, name, currentType);
			methodName.obj = method;
			Tab.openScope();
		}
		
	}
	
	
	
	public void visit(MethodDeclaration methodDeclaration ) {
		if (method!= null) {
			Tab.chainLocalSymbols(method);
			Tab.closeScope();
			method = null;
		}
		
		for (Entry<GoToStatement, String> i : gotonaredbe.entrySet()) {
			GoToStatement key = i.getKey();
			String val = i.getValue();
			if (!labeleZaGoto.containsKey(val)) {
				report_error("go to greska", key);
			}
		}
		//else report_error("Nije otvoren scope", methodDeclaration);
		
	}
	
	
	public void visit(FormParamBrackes formParamBrackes) {
		String name = formParamBrackes.getI1();
		Struct type = currentType;
		if(Tab.currentScope.findSymbol(name) != null) {
			report_error("Deklarisana promenljiva "+ formParamBrackes.getI1(), formParamBrackes);
		} else {
			Tab.insert(Obj.Var, name, new Struct(Struct.Array, type));
		}
				
	}
	
	public void visit(FormParamNoBrackes formParamBrackes) {
		String name = formParamBrackes.getI1();
		Struct type = currentType;
		if(Tab.currentScope.findSymbol(name) != null) {
			report_error("Deklarisana promenljiva "+ formParamBrackes.getI1(), formParamBrackes);
		} else {
			Tab.insert(Obj.Var, name, type);
		}
				
	}
	
	
	
	
	
	
	
	public void visit(AddOperationTerm addOperationTerm) {
        addOperationTerm.obj = addOperationTerm.getExprAfterTerm().obj;
    }
	
	
	public void visit(NegativeTerm negativeTerm) {
        Obj expression = negativeTerm.getExprAfterTerm().obj;
        if (expression.getType().getKind() == Struct.Int) {
            negativeTerm.obj = expression;
        } else {
        	report_error("Nije int ", negativeTerm);
            negativeTerm.obj = new Obj(Obj.NO_VALUE, "", Tab.noType);
        }
    }

	public void visit(TermList termList) {
        Obj termTree = termList.getTerm().obj;
        Obj factor = termList.getExprAfterTerm().obj;

        if (termTree.getType().equals(Tab.intType) &&
                factor.getType().equals(Tab.intType)) {
            termList.obj = new Obj(Obj.Var, "", Tab.intType);
        } else {
        	report_error("Nisu dobrog tipa za sabiranje", termList);
            termList.obj = new Obj(Obj.NO_VALUE, "", Tab.noType);
        }

	}
	
	public void visit(OneTerm oneTerm) {
		oneTerm.obj = oneTerm.getTerm().obj;
	}
	
	
	
	public void visit(TermStmtOnly term) {
        term.obj = term.getFactor().obj;
    }
	
	
	public void visit(TermStmt termStmt) {
        Obj termTree = termStmt.getTerm().obj;
        Obj factor = termStmt.getFactor().obj;
        if (termTree == null || factor == null) {
        	report_error("Nisu dobrog tipa za sabiranje", termStmt);
        }

        if (factor.getType().equals(Tab.intType) && termTree.getType().compatibleWith(factor.getType())) {
        	termStmt.obj = new Obj(Obj.Var, "", Tab.intType);
        } else {
        	report_error("Nisu dobrog tipa za sabiranje", termStmt);
        	termStmt.obj = new Obj(Obj.NO_VALUE, "", Tab.noType);
        }

    }
	
	
	
	
	
	
	
	
	
	
	
	public void visit(CleanDesignator cleanDesignator) {
        Obj temp = Tab.find(cleanDesignator.getIdentification());
        //
        if (temp == Tab.noObj) {
        	report_error("Neodgovarajuce ime promenljive no.obj ", cleanDesignator);
            temp = new Obj(Obj.NO_VALUE, "", Tab.noType);
        }
        
        if ( temp.getKind() == Obj.Type  ) {
        	report_error("Neodgovarajuce ime promenljive obj.type ", cleanDesignator);
            temp = new Obj(Obj.NO_VALUE, "", Tab.noType);
        }
        
        if ( temp.getKind() == Obj.Prog  ) {
        	report_error("Neodgovarajuce ime promenljive obj.prog ", cleanDesignator);
            temp = new Obj(Obj.NO_VALUE, "", Tab.noType);
        }
        
        cleanDesignator.obj = temp;
    }

	@Override
	public void visit(ArrayElementAccessDesignator designatorName2) {
		
		if(designatorName2.getDesName().obj == Tab.noObj) {
			designatorName2.obj = Tab.noObj;
		}
		else if(!designatorName2.getExpr().obj.getType().equals(Tab.intType)) {
			report_error("GRESKA: Expr za indeksiranje niza mora biti tipa - Int", designatorName2);
			designatorName2.obj = Tab.noObj;
		}
		else {
			designatorName2.obj = new Obj(Obj.Elem, designatorName2.getDesName().obj.getName() + "[num]", designatorName2.getDesName().obj.getType().getElemType());
			report_info("Pristup elementu niza: " + designatorName2.getDesName(), designatorName2);
		}
	}
   
	@Override
	public void visit(DesNameDecl designatorArrayName) {
		Obj arrVar = Tab.find(designatorArrayName.getI1());
		if(arrVar.equals(Tab.noObj)) {
			report_error("GRESKA: Niz nije deklarisan " +designatorArrayName.getI1(), designatorArrayName);
			designatorArrayName.obj = Tab.noObj;
		}
		else if(arrVar.getKind() == Obj.Var && arrVar.getType().getKind() == Struct.Array){
			designatorArrayName.obj = arrVar;
		}
		else {
			report_error("GRESKA: Nevalidna promenljiva niza " +designatorArrayName.getI1(), designatorArrayName);
			designatorArrayName.obj = Tab.noObj;
		}
	}
	
	
	public void visit(AssignopExpr assignopExpr) {
		Obj obj = assignopExpr.getDesignator().obj;
		if(obj.getKind() != Obj.Var && obj.getKind() != Obj.Elem) {
			report_error("Nije l- vrednost ne moze dodela ", assignopExpr);
		}
		
		
		
		
		if (!assignopExpr.getExpr().obj.getType().compatibleWith(obj.getType())){
			report_error("Nisu istog tipa ", assignopExpr);
		}
	}
	

	public void visit(FactorNumConst factorNumConst) {
		factorNumConst.obj = new Obj(Obj.Con,"",Tab.intType);
	}
	
	
	public void visit(FactorCharConst factorCharConst) {
		factorCharConst.obj = new Obj(Obj.Con,"",Tab.charType)  ;
	}
	
	
	public void visit(FactorBoolConst factorBoolConst) {
		factorBoolConst.obj = new Obj(Obj.Con,"", Tab.find("bool").getType()) ;
	}
	
	public void visit(FactorNewNoExpr factorNewNoExpr) {
		factorNewNoExpr.obj = new Obj(Obj.Con,"",new Struct(Struct.Array , (Tab.find(factorNewNoExpr.getType().getTypeName())).getType())) ;
	}
	public void visit(FactorDesignatorNoParam factorDesignatorNoParam) {
		factorDesignatorNoParam.obj = factorDesignatorNoParam.getDesignator().obj;
	}
	public void visit(FactorDesignatorParam factorDesignatorParam) {
		factorDesignatorParam.obj = factorDesignatorParam.getDesignator().obj;
		
		if(factorDesignatorParam.getDesignator().obj.getKind() != Obj.Meth ) {
			report_error("Ne moze nije funkcija ", factorDesignatorParam);
		}
	}
	
	
	public void visit(DesignatorStatIncrement designatorStatIncrement) {
		if(designatorStatIncrement.getDesignator().obj.getType() != Tab.intType){
			report_error("Nije int ", designatorStatIncrement);
		}
		if(designatorStatIncrement.getDesignator().obj.getKind() != Obj.Var && designatorStatIncrement.getDesignator().obj.getKind() != Obj.Elem){
			report_error("Nije l-vrednost ", designatorStatIncrement);
		}
	}
	
	public void visit(DesignatorStatDecrement designatorStatDecrement) {
		if(designatorStatDecrement.getDesignator().obj.getType() != Tab.intType){
			report_error("Nije int ", designatorStatDecrement);
		}
		if(designatorStatDecrement.getDesignator().obj.getKind() != Obj.Var && designatorStatDecrement.getDesignator().obj.getKind() != Obj.Elem){
			report_error("Nije l-vrednost ", designatorStatDecrement);
		}
	}
	
	
	
	public void visit(FactorNewExpr factorNewExpr) {
		factorNewExpr.obj =new Obj(Obj.Con,"", new Struct(Struct.Array , factorNewExpr.getType().struct));
		
		if(factorNewExpr.getExpr().obj.getType() != Tab.intType) {
			report_error("Nije velicina niza ceo broj ", factorNewExpr);
		}
	}
	
	
	public void visit(FactorExpr factorExpr) {
		factorExpr.obj = factorExpr.getExpr().obj;
	}
	
	
	public void visit(PrintStatement printStatement) {
		
		if(printStatement.getExpr().obj.getType() != Tab.intType 
				&& printStatement.getExpr().obj.getType() != Tab.charType
				&& printStatement.getExpr().obj.getType() != Tab.find("bool").getType() &&
				printStatement.getExpr().obj.getKind() != Obj.Var ){
			report_error("Nije dobar tip ", printStatement);
		}
		
	}
	
	public void visit(ReadStatement readStatement) {
		if(readStatement.getDesignator().obj.getType() != Tab.intType 
				&& readStatement.getDesignator().obj.getType() != Tab.charType 
				&& readStatement.getDesignator().obj.getType() != Tab.find("bool").getType()) {
			report_error("Nije dobar tip  ", readStatement);
		}
		if(readStatement.getDesignator().obj.getKind() != Obj.Var && readStatement.getDesignator().obj.getKind() != Obj.Elem){
			report_error("Nije l-vrednost ", readStatement);
		}
	}
	
	
	
	
	
	
	public static HashMap<GoToStatement, String>gotonaredbe = new HashMap<>();
	public static HashMap<String, Integer>labeleZaGoto =new HashMap<>();
	
	
	public void visit(GoToStatement gotostet) {
		gotonaredbe.put(gotostet, gotostet.getLabel().getLabel());
	}
	
	
	public void visit(StatementWithLabel gotostet) {
		if (labeleZaGoto.containsKey(gotostet.getLabel().getLabel()))
			report_error("Vec ima labelu", gotostet);
		labeleZaGoto.put(gotostet.getLabel().getLabel(), gotostet.getLine());
	}
	/*
	public void visit (CaretDecl caret) {
		if(caret.getDesignator().obj.getType().getKind() != Struct.Array) {
			report_error("Caret greska", caret);
		}
	}
	DesignatorStatement::= (CaretDecl) Designator CARET NUM_CONST
	*/
	
    
}
