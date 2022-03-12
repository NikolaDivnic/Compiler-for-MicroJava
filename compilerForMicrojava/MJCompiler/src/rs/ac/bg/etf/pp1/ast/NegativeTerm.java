// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class NegativeTerm extends Expr {

    private Neg Neg;
    private ExprAfterTerm ExprAfterTerm;

    public NegativeTerm (Neg Neg, ExprAfterTerm ExprAfterTerm) {
        this.Neg=Neg;
        if(Neg!=null) Neg.setParent(this);
        this.ExprAfterTerm=ExprAfterTerm;
        if(ExprAfterTerm!=null) ExprAfterTerm.setParent(this);
    }

    public Neg getNeg() {
        return Neg;
    }

    public void setNeg(Neg Neg) {
        this.Neg=Neg;
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
        if(Neg!=null) Neg.accept(visitor);
        if(ExprAfterTerm!=null) ExprAfterTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Neg!=null) Neg.traverseTopDown(visitor);
        if(ExprAfterTerm!=null) ExprAfterTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Neg!=null) Neg.traverseBottomUp(visitor);
        if(ExprAfterTerm!=null) ExprAfterTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NegativeTerm(\n");

        if(Neg!=null)
            buffer.append(Neg.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprAfterTerm!=null)
            buffer.append(ExprAfterTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NegativeTerm]");
        return buffer.toString();
    }
}
