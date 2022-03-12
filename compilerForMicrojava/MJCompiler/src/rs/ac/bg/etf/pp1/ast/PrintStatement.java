// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class PrintStatement extends SingleStatement {

    private Expr Expr;
    private PrintExpr PrintExpr;

    public PrintStatement (Expr Expr, PrintExpr PrintExpr) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.PrintExpr=PrintExpr;
        if(PrintExpr!=null) PrintExpr.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public PrintExpr getPrintExpr() {
        return PrintExpr;
    }

    public void setPrintExpr(PrintExpr PrintExpr) {
        this.PrintExpr=PrintExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(PrintExpr!=null) PrintExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(PrintExpr!=null) PrintExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(PrintExpr!=null) PrintExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintStatement(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PrintExpr!=null)
            buffer.append(PrintExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintStatement]");
        return buffer.toString();
    }
}
