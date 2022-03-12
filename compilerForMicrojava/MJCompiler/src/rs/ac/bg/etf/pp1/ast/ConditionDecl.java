// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class ConditionDecl extends Condition {

    private CondTerm CondTerm;
    private ConditionAfterCondTerm ConditionAfterCondTerm;

    public ConditionDecl (CondTerm CondTerm, ConditionAfterCondTerm ConditionAfterCondTerm) {
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
        this.ConditionAfterCondTerm=ConditionAfterCondTerm;
        if(ConditionAfterCondTerm!=null) ConditionAfterCondTerm.setParent(this);
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public ConditionAfterCondTerm getConditionAfterCondTerm() {
        return ConditionAfterCondTerm;
    }

    public void setConditionAfterCondTerm(ConditionAfterCondTerm ConditionAfterCondTerm) {
        this.ConditionAfterCondTerm=ConditionAfterCondTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondTerm!=null) CondTerm.accept(visitor);
        if(ConditionAfterCondTerm!=null) ConditionAfterCondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
        if(ConditionAfterCondTerm!=null) ConditionAfterCondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        if(ConditionAfterCondTerm!=null) ConditionAfterCondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionDecl(\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionAfterCondTerm!=null)
            buffer.append(ConditionAfterCondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionDecl]");
        return buffer.toString();
    }
}
