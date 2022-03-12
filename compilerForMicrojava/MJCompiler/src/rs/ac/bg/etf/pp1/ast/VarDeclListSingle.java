// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class VarDeclListSingle implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private VarDSingleBracket VarDSingleBracket;

    public VarDeclListSingle (VarDSingleBracket VarDSingleBracket) {
        this.VarDSingleBracket=VarDSingleBracket;
        if(VarDSingleBracket!=null) VarDSingleBracket.setParent(this);
    }

    public VarDSingleBracket getVarDSingleBracket() {
        return VarDSingleBracket;
    }

    public void setVarDSingleBracket(VarDSingleBracket VarDSingleBracket) {
        this.VarDSingleBracket=VarDSingleBracket;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDSingleBracket!=null) VarDSingleBracket.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDSingleBracket!=null) VarDSingleBracket.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDSingleBracket!=null) VarDSingleBracket.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclListSingle(\n");

        if(VarDSingleBracket!=null)
            buffer.append(VarDSingleBracket.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclListSingle]");
        return buffer.toString();
    }
}
