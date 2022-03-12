package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.concepts.Obj;

public class WrapperKlasa {
	public int instr;
	public Obj obj;
	
	public static int load = -1;
	
	public WrapperKlasa(int instr) {
		this.instr = instr;
	}
	
	public WrapperKlasa(Obj obj) {
			this.obj = obj;
		}
	
	public WrapperKlasa(int instr, Obj obj) {
		this.instr = instr;
		this.obj = obj;
	}


}
