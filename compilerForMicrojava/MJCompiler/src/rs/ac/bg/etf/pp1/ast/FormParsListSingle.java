// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class FormParsListSingle implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private FormParamFirstPart FormParamFirstPart;

    public FormParsListSingle (Type Type, FormParamFirstPart FormParamFirstPart) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FormParamFirstPart=FormParamFirstPart;
        if(FormParamFirstPart!=null) FormParamFirstPart.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FormParamFirstPart getFormParamFirstPart() {
        return FormParamFirstPart;
    }

    public void setFormParamFirstPart(FormParamFirstPart FormParamFirstPart) {
        this.FormParamFirstPart=FormParamFirstPart;
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
        if(Type!=null) Type.accept(visitor);
        if(FormParamFirstPart!=null) FormParamFirstPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FormParamFirstPart!=null) FormParamFirstPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FormParamFirstPart!=null) FormParamFirstPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsListSingle(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParamFirstPart!=null)
            buffer.append(FormParamFirstPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsListSingle]");
        return buffer.toString();
    }
}
