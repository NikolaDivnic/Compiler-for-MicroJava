// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarations extends VarDeclarationsList {

    private VarDeclarationsList VarDeclarationsList;
    private VarDecl VarDecl;

    public VarDeclarations (VarDeclarationsList VarDeclarationsList, VarDecl VarDecl) {
        this.VarDeclarationsList=VarDeclarationsList;
        if(VarDeclarationsList!=null) VarDeclarationsList.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public VarDeclarationsList getVarDeclarationsList() {
        return VarDeclarationsList;
    }

    public void setVarDeclarationsList(VarDeclarationsList VarDeclarationsList) {
        this.VarDeclarationsList=VarDeclarationsList;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclarationsList!=null) VarDeclarationsList.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclarationsList!=null) VarDeclarationsList.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclarationsList!=null) VarDeclarationsList.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarations(\n");

        if(VarDeclarationsList!=null)
            buffer.append(VarDeclarationsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarations]");
        return buffer.toString();
    }
}
