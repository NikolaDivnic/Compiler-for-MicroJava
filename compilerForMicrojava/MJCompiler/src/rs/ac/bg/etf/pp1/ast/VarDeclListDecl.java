// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class VarDeclListDecl extends VarDeclList {

    private VarDeclListSingle VarDeclListSingle;
    private VarDeclList VarDeclList;

    public VarDeclListDecl (VarDeclListSingle VarDeclListSingle, VarDeclList VarDeclList) {
        this.VarDeclListSingle=VarDeclListSingle;
        if(VarDeclListSingle!=null) VarDeclListSingle.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
    }

    public VarDeclListSingle getVarDeclListSingle() {
        return VarDeclListSingle;
    }

    public void setVarDeclListSingle(VarDeclListSingle VarDeclListSingle) {
        this.VarDeclListSingle=VarDeclListSingle;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclListSingle!=null) VarDeclListSingle.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclListSingle!=null) VarDeclListSingle.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclListSingle!=null) VarDeclListSingle.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclListDecl(\n");

        if(VarDeclListSingle!=null)
            buffer.append(VarDeclListSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclListDecl]");
        return buffer.toString();
    }
}
