// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class AddOperationTerm extends Expr {

    private ExprAfterTerm ExprAfterTerm;

    public AddOperationTerm (ExprAfterTerm ExprAfterTerm) {
        this.ExprAfterTerm=ExprAfterTerm;
        if(ExprAfterTerm!=null) ExprAfterTerm.setParent(this);
    }

    public ExprAfterTerm getExprAfterTerm() {
        return ExprAfterTerm;
    }

    public void setExprAfterTerm(ExprAfterTerm ExprAfterTerm) {
        this.ExprAfterTerm=ExprAfterTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprAfterTerm!=null) ExprAfterTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprAfterTerm!=null) ExprAfterTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprAfterTerm!=null) ExprAfterTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AddOperationTerm(\n");

        if(ExprAfterTerm!=null)
            buffer.append(ExprAfterTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AddOperationTerm]");
        return buffer.toString();
    }
}
