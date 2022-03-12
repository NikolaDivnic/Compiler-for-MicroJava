// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class CondTermAfterList extends CondTermAfter {

    private CondTermAfter CondTermAfter;
    private CondTermAfterSingle CondTermAfterSingle;

    public CondTermAfterList (CondTermAfter CondTermAfter, CondTermAfterSingle CondTermAfterSingle) {
        this.CondTermAfter=CondTermAfter;
        if(CondTermAfter!=null) CondTermAfter.setParent(this);
        this.CondTermAfterSingle=CondTermAfterSingle;
        if(CondTermAfterSingle!=null) CondTermAfterSingle.setParent(this);
    }

    public CondTermAfter getCondTermAfter() {
        return CondTermAfter;
    }

    public void setCondTermAfter(CondTermAfter CondTermAfter) {
        this.CondTermAfter=CondTermAfter;
    }

    public CondTermAfterSingle getCondTermAfterSingle() {
        return CondTermAfterSingle;
    }

    public void setCondTermAfterSingle(CondTermAfterSingle CondTermAfterSingle) {
        this.CondTermAfterSingle=CondTermAfterSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondTermAfter!=null) CondTermAfter.accept(visitor);
        if(CondTermAfterSingle!=null) CondTermAfterSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondTermAfter!=null) CondTermAfter.traverseTopDown(visitor);
        if(CondTermAfterSingle!=null) CondTermAfterSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondTermAfter!=null) CondTermAfter.traverseBottomUp(visitor);
        if(CondTermAfterSingle!=null) CondTermAfterSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTermAfterList(\n");

        if(CondTermAfter!=null)
            buffer.append(CondTermAfter.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTermAfterSingle!=null)
            buffer.append(CondTermAfterSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTermAfterList]");
        return buffer.toString();
    }
}
