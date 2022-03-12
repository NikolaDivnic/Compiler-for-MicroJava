// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclarations extends Decl {

    private ClassDeclaration ClassDeclaration;
    private ClassBody ClassBody;

    public ClassDeclarations (ClassDeclaration ClassDeclaration, ClassBody ClassBody) {
        this.ClassDeclaration=ClassDeclaration;
        if(ClassDeclaration!=null) ClassDeclaration.setParent(this);
        this.ClassBody=ClassBody;
        if(ClassBody!=null) ClassBody.setParent(this);
    }

    public ClassDeclaration getClassDeclaration() {
        return ClassDeclaration;
    }

    public void setClassDeclaration(ClassDeclaration ClassDeclaration) {
        this.ClassDeclaration=ClassDeclaration;
    }

    public ClassBody getClassBody() {
        return ClassBody;
    }

    public void setClassBody(ClassBody ClassBody) {
        this.ClassBody=ClassBody;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassDeclaration!=null) ClassDeclaration.accept(visitor);
        if(ClassBody!=null) ClassBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassDeclaration!=null) ClassDeclaration.traverseTopDown(visitor);
        if(ClassBody!=null) ClassBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassDeclaration!=null) ClassDeclaration.traverseBottomUp(visitor);
        if(ClassBody!=null) ClassBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclarations(\n");

        if(ClassDeclaration!=null)
            buffer.append(ClassDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassBody!=null)
            buffer.append(ClassBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclarations]");
        return buffer.toString();
    }
}
