// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclListDecl extends ConstDeclList {

    private ConstDeclList ConstDeclList;
    private ConstDeclListSingle ConstDeclListSingle;

    public ConstDeclListDecl (ConstDeclList ConstDeclList, ConstDeclListSingle ConstDeclListSingle) {
        this.ConstDeclList=ConstDeclList;
        if(ConstDeclList!=null) ConstDeclList.setParent(this);
        this.ConstDeclListSingle=ConstDeclListSingle;
        if(ConstDeclListSingle!=null) ConstDeclListSingle.setParent(this);
    }

    public ConstDeclList getConstDeclList() {
        return ConstDeclList;
    }

    public void setConstDeclList(ConstDeclList ConstDeclList) {
        this.ConstDeclList=ConstDeclList;
    }

    public ConstDeclListSingle getConstDeclListSingle() {
        return ConstDeclListSingle;
    }

    public void setConstDeclListSingle(ConstDeclListSingle ConstDeclListSingle) {
        this.ConstDeclListSingle=ConstDeclListSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclList!=null) ConstDeclList.accept(visitor);
        if(ConstDeclListSingle!=null) ConstDeclListSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseTopDown(visitor);
        if(ConstDeclListSingle!=null) ConstDeclListSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclList!=null) ConstDeclList.traverseBottomUp(visitor);
        if(ConstDeclListSingle!=null) ConstDeclListSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclListDecl(\n");

        if(ConstDeclList!=null)
            buffer.append(ConstDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclListSingle!=null)
            buffer.append(ConstDeclListSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclListDecl]");
        return buffer.toString();
    }
}
