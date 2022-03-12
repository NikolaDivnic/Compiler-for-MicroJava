// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class ConditionAfterList extends ConditionAfterCondTerm {

    private ConditionAfterCondTerm ConditionAfterCondTerm;
    private ConditionAfterSingle ConditionAfterSingle;

    public ConditionAfterList (ConditionAfterCondTerm ConditionAfterCondTerm, ConditionAfterSingle ConditionAfterSingle) {
        this.ConditionAfterCondTerm=ConditionAfterCondTerm;
        if(ConditionAfterCondTerm!=null) ConditionAfterCondTerm.setParent(this);
        this.ConditionAfterSingle=ConditionAfterSingle;
        if(ConditionAfterSingle!=null) ConditionAfterSingle.setParent(this);
    }

    public ConditionAfterCondTerm getConditionAfterCondTerm() {
        return ConditionAfterCondTerm;
    }

    public void setConditionAfterCondTerm(ConditionAfterCondTerm ConditionAfterCondTerm) {
        this.ConditionAfterCondTerm=ConditionAfterCondTerm;
    }

    public ConditionAfterSingle getConditionAfterSingle() {
        return ConditionAfterSingle;
    }

    public void setConditionAfterSingle(ConditionAfterSingle ConditionAfterSingle) {
        this.ConditionAfterSingle=ConditionAfterSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConditionAfterCondTerm!=null) ConditionAfterCondTerm.accept(visitor);
        if(ConditionAfterSingle!=null) ConditionAfterSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionAfterCondTerm!=null) ConditionAfterCondTerm.traverseTopDown(visitor);
        if(ConditionAfterSingle!=null) ConditionAfterSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionAfterCondTerm!=null) ConditionAfterCondTerm.traverseBottomUp(visitor);
        if(ConditionAfterSingle!=null) ConditionAfterSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionAfterList(\n");

        if(ConditionAfterCondTerm!=null)
            buffer.append(ConditionAfterCondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionAfterSingle!=null)
            buffer.append(ConditionAfterSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionAfterList]");
        return buffer.toString();
    }
}
