// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class RootClass extends ClassDeclaration {

    private String className;

    public RootClass (String className) {
        this.className=className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className=className;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RootClass(\n");

        buffer.append(" "+tab+className);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RootClass]");
        return buffer.toString();
    }
}
