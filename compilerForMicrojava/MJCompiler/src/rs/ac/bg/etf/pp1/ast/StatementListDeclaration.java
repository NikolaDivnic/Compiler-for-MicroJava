// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class StatementListDeclaration extends Statements {

    private StatementListDecl StatementListDecl;

    public StatementListDeclaration (StatementListDecl StatementListDecl) {
        this.StatementListDecl=StatementListDecl;
        if(StatementListDecl!=null) StatementListDecl.setParent(this);
    }

    public StatementListDecl getStatementListDecl() {
        return StatementListDecl;
    }

    public void setStatementListDecl(StatementListDecl StatementListDecl) {
        this.StatementListDecl=StatementListDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementListDecl!=null) StatementListDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementListDecl!=null) StatementListDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementListDecl!=null) StatementListDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementListDeclaration(\n");

        if(StatementListDecl!=null)
            buffer.append(StatementListDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementListDeclaration]");
        return buffer.toString();
    }
}
