// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class ClassWithConstructor extends ClassMethods {

    private MethodDeclarations MethodDeclarations;

    public ClassWithConstructor (MethodDeclarations MethodDeclarations) {
        this.MethodDeclarations=MethodDeclarations;
        if(MethodDeclarations!=null) MethodDeclarations.setParent(this);
    }

    public MethodDeclarations getMethodDeclarations() {
        return MethodDeclarations;
    }

    public void setMethodDeclarations(MethodDeclarations MethodDeclarations) {
        this.MethodDeclarations=MethodDeclarations;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDeclarations!=null) MethodDeclarations.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclarations!=null) MethodDeclarations.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclarations!=null) MethodDeclarations.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassWithConstructor(\n");

        if(MethodDeclarations!=null)
            buffer.append(MethodDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassWithConstructor]");
        return buffer.toString();
    }
}
