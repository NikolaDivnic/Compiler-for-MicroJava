// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class VarDeclDecl extends VarDecl {

    private Type Type;
    private VarDSingleBracket VarDSingleBracket;
    private VarDeclList VarDeclList;

    public VarDeclDecl (Type Type, VarDSingleBracket VarDSingleBracket, VarDeclList VarDeclList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarDSingleBracket=VarDSingleBracket;
        if(VarDSingleBracket!=null) VarDSingleBracket.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VarDSingleBracket getVarDSingleBracket() {
        return VarDSingleBracket;
    }

    public void setVarDSingleBracket(VarDSingleBracket VarDSingleBracket) {
        this.VarDSingleBracket=VarDSingleBracket;
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
        if(Type!=null) Type.accept(visitor);
        if(VarDSingleBracket!=null) VarDSingleBracket.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarDSingleBracket!=null) VarDSingleBracket.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarDSingleBracket!=null) VarDSingleBracket.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDSingleBracket!=null)
            buffer.append(VarDSingleBracket.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclDecl]");
        return buffer.toString();
    }
}
