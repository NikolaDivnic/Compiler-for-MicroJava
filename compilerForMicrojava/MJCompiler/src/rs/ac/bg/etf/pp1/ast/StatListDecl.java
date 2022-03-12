// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class StatListDecl extends StatementListDecl {

    private StatementListDecl StatementListDecl;
    private Statement Statement;

    public StatListDecl (StatementListDecl StatementListDecl, Statement Statement) {
        this.StatementListDecl=StatementListDecl;
        if(StatementListDecl!=null) StatementListDecl.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public StatementListDecl getStatementListDecl() {
        return StatementListDecl;
    }

    public void setStatementListDecl(StatementListDecl StatementListDecl) {
        this.StatementListDecl=StatementListDecl;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementListDecl!=null) StatementListDecl.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementListDecl!=null) StatementListDecl.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementListDecl!=null) StatementListDecl.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatListDecl(\n");

        if(StatementListDecl!=null)
            buffer.append(StatementListDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatListDecl]");
        return buffer.toString();
    }
}
