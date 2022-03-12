// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class FactorNewExpr extends Factor {

    private NewExpr NewExpr;
    private Type Type;
    private Expr Expr;

    public FactorNewExpr (NewExpr NewExpr, Type Type, Expr Expr) {
        this.NewExpr=NewExpr;
        if(NewExpr!=null) NewExpr.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public NewExpr getNewExpr() {
        return NewExpr;
    }

    public void setNewExpr(NewExpr NewExpr) {
        this.NewExpr=NewExpr;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NewExpr!=null) NewExpr.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NewExpr!=null) NewExpr.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NewExpr!=null) NewExpr.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNewExpr(\n");

        if(NewExpr!=null)
            buffer.append(NewExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNewExpr]");
        return buffer.toString();
    }
}
