// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class CondTermDecl extends CondTerm {

    private CondFact CondFact;
    private CondTermAfter CondTermAfter;

    public CondTermDecl (CondFact CondFact, CondTermAfter CondTermAfter) {
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
        this.CondTermAfter=CondTermAfter;
        if(CondTermAfter!=null) CondTermAfter.setParent(this);
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public CondTermAfter getCondTermAfter() {
        return CondTermAfter;
    }

    public void setCondTermAfter(CondTermAfter CondTermAfter) {
        this.CondTermAfter=CondTermAfter;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondFact!=null) CondFact.accept(visitor);
        if(CondTermAfter!=null) CondTermAfter.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
        if(CondTermAfter!=null) CondTermAfter.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        if(CondTermAfter!=null) CondTermAfter.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTermDecl(\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTermAfter!=null)
            buffer.append(CondTermAfter.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTermDecl]");
        return buffer.toString();
    }
}
