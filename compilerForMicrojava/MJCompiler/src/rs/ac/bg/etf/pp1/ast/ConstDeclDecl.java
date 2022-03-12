// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclDecl extends ConstDecl {

    private Type Type;
    private String I2;
    private ConstDeclAfterAssign ConstDeclAfterAssign;
    private ConstDeclList ConstDeclList;

    public ConstDeclDecl (Type Type, String I2, ConstDeclAfterAssign ConstDeclAfterAssign, ConstDeclList ConstDeclList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.ConstDeclAfterAssign=ConstDeclAfterAssign;
        if(ConstDeclAfterAssign!=null) ConstDeclAfterAssign.setParent(this);
        this.ConstDeclList=ConstDeclList;
        if(ConstDeclList!=null) ConstDeclList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public ConstDeclAfterAssign getConstDeclAfterAssign() {
        return ConstDeclAfterAssign;
    }

    public void setConstDeclAfterAssign(ConstDeclAfterAssign ConstDeclAfterAssign) {
        this.ConstDeclAfterAssign=ConstDeclAfterAssign;
    }

    public ConstDeclList getConstDeclList() {
        return ConstDeclList;
    }

    public void setConstDeclList(ConstDeclList ConstDeclList) {
        this.ConstDeclList=ConstDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ConstDeclAfterAssign!=null) ConstDeclAfterAssign.accept(visitor);
        if(ConstDeclList!=null) ConstDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstDeclAfterAssign!=null) ConstDeclAfterAssign.traverseTopDown(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstDeclAfterAssign!=null) ConstDeclAfterAssign.traverseBottomUp(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(ConstDeclAfterAssign!=null)
            buffer.append(ConstDeclAfterAssign.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclList!=null)
            buffer.append(ConstDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclDecl]");
        return buffer.toString();
    }
}
