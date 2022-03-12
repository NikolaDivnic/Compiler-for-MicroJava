// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class HaveExpr extends PrintExpr {

    private PrintWidth PrintWidth;

    public HaveExpr (PrintWidth PrintWidth) {
        this.PrintWidth=PrintWidth;
        if(PrintWidth!=null) PrintWidth.setParent(this);
    }

    public PrintWidth getPrintWidth() {
        return PrintWidth;
    }

    public void setPrintWidth(PrintWidth PrintWidth) {
        this.PrintWidth=PrintWidth;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PrintWidth!=null) PrintWidth.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PrintWidth!=null) PrintWidth.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PrintWidth!=null) PrintWidth.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("HaveExpr(\n");

        if(PrintWidth!=null)
            buffer.append(PrintWidth.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [HaveExpr]");
        return buffer.toString();
    }
}
