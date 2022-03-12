// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class AfterVarDeclarations extends ClassBody {

    private AfterVarDecl AfterVarDecl;

    public AfterVarDeclarations (AfterVarDecl AfterVarDecl) {
        this.AfterVarDecl=AfterVarDecl;
        if(AfterVarDecl!=null) AfterVarDecl.setParent(this);
    }

    public AfterVarDecl getAfterVarDecl() {
        return AfterVarDecl;
    }

    public void setAfterVarDecl(AfterVarDecl AfterVarDecl) {
        this.AfterVarDecl=AfterVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AfterVarDecl!=null) AfterVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AfterVarDecl!=null) AfterVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AfterVarDecl!=null) AfterVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AfterVarDeclarations(\n");

        if(AfterVarDecl!=null)
            buffer.append(AfterVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AfterVarDeclarations]");
        return buffer.toString();
    }
}
