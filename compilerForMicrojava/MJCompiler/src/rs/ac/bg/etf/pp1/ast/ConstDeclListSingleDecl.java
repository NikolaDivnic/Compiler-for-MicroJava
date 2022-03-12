// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclListSingleDecl extends ConstDeclListSingle {

    private String I1;
    private ConstDeclAfterAssign ConstDeclAfterAssign;

    public ConstDeclListSingleDecl (String I1, ConstDeclAfterAssign ConstDeclAfterAssign) {
        this.I1=I1;
        this.ConstDeclAfterAssign=ConstDeclAfterAssign;
        if(ConstDeclAfterAssign!=null) ConstDeclAfterAssign.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ConstDeclAfterAssign getConstDeclAfterAssign() {
        return ConstDeclAfterAssign;
    }

    public void setConstDeclAfterAssign(ConstDeclAfterAssign ConstDeclAfterAssign) {
        this.ConstDeclAfterAssign=ConstDeclAfterAssign;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclAfterAssign!=null) ConstDeclAfterAssign.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclAfterAssign!=null) ConstDeclAfterAssign.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclAfterAssign!=null) ConstDeclAfterAssign.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclListSingleDecl(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ConstDeclAfterAssign!=null)
            buffer.append(ConstDeclAfterAssign.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclListSingleDecl]");
        return buffer.toString();
    }
}
