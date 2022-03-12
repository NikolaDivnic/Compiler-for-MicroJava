// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class FactorExpr extends Factor {

    private ParanthesesBegin ParanthesesBegin;
    private Expr Expr;
    private ParanthesesEnd ParanthesesEnd;

    public FactorExpr (ParanthesesBegin ParanthesesBegin, Expr Expr, ParanthesesEnd ParanthesesEnd) {
        this.ParanthesesBegin=ParanthesesBegin;
        if(ParanthesesBegin!=null) ParanthesesBegin.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.ParanthesesEnd=ParanthesesEnd;
        if(ParanthesesEnd!=null) ParanthesesEnd.setParent(this);
    }

    public ParanthesesBegin getParanthesesBegin() {
        return ParanthesesBegin;
    }

    public void setParanthesesBegin(ParanthesesBegin ParanthesesBegin) {
        this.ParanthesesBegin=ParanthesesBegin;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public ParanthesesEnd getParanthesesEnd() {
        return ParanthesesEnd;
    }

    public void setParanthesesEnd(ParanthesesEnd ParanthesesEnd) {
        this.ParanthesesEnd=ParanthesesEnd;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ParanthesesBegin!=null) ParanthesesBegin.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
        if(ParanthesesEnd!=null) ParanthesesEnd.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ParanthesesBegin!=null) ParanthesesBegin.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(ParanthesesEnd!=null) ParanthesesEnd.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ParanthesesBegin!=null) ParanthesesBegin.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(ParanthesesEnd!=null) ParanthesesEnd.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorExpr(\n");

        if(ParanthesesBegin!=null)
            buffer.append(ParanthesesBegin.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ParanthesesEnd!=null)
            buffer.append(ParanthesesEnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorExpr]");
        return buffer.toString();
    }
}
