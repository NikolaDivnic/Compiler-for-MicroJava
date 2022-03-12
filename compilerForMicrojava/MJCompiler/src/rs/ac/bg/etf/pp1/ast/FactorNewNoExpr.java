// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class FactorNewNoExpr extends Factor {

    private NewExpr NewExpr;
    private Type Type;

    public FactorNewNoExpr (NewExpr NewExpr, Type Type) {
        this.NewExpr=NewExpr;
        if(NewExpr!=null) NewExpr.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NewExpr!=null) NewExpr.accept(visitor);
        if(Type!=null) Type.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NewExpr!=null) NewExpr.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NewExpr!=null) NewExpr.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNewNoExpr(\n");

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

        buffer.append(tab);
        buffer.append(") [FactorNewNoExpr]");
        return buffer.toString();
    }
}
