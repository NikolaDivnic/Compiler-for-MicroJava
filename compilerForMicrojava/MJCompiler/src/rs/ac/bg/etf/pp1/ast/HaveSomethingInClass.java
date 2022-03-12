// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class HaveSomethingInClass extends AfterVarDecl {

    private ClassMethods ClassMethods;

    public HaveSomethingInClass (ClassMethods ClassMethods) {
        this.ClassMethods=ClassMethods;
        if(ClassMethods!=null) ClassMethods.setParent(this);
    }

    public ClassMethods getClassMethods() {
        return ClassMethods;
    }

    public void setClassMethods(ClassMethods ClassMethods) {
        this.ClassMethods=ClassMethods;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassMethods!=null) ClassMethods.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassMethods!=null) ClassMethods.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassMethods!=null) ClassMethods.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("HaveSomethingInClass(\n");

        if(ClassMethods!=null)
            buffer.append(ClassMethods.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [HaveSomethingInClass]");
        return buffer.toString();
    }
}
