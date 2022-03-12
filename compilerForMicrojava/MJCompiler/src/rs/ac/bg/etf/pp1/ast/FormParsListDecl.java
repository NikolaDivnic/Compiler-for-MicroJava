// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class FormParsListDecl extends FormParsList {

    private FormParsList FormParsList;
    private FormParsListSingle FormParsListSingle;

    public FormParsListDecl (FormParsList FormParsList, FormParsListSingle FormParsListSingle) {
        this.FormParsList=FormParsList;
        if(FormParsList!=null) FormParsList.setParent(this);
        this.FormParsListSingle=FormParsListSingle;
        if(FormParsListSingle!=null) FormParsListSingle.setParent(this);
    }

    public FormParsList getFormParsList() {
        return FormParsList;
    }

    public void setFormParsList(FormParsList FormParsList) {
        this.FormParsList=FormParsList;
    }

    public FormParsListSingle getFormParsListSingle() {
        return FormParsListSingle;
    }

    public void setFormParsListSingle(FormParsListSingle FormParsListSingle) {
        this.FormParsListSingle=FormParsListSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParsList!=null) FormParsList.accept(visitor);
        if(FormParsListSingle!=null) FormParsListSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsList!=null) FormParsList.traverseTopDown(visitor);
        if(FormParsListSingle!=null) FormParsListSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsList!=null) FormParsList.traverseBottomUp(visitor);
        if(FormParsListSingle!=null) FormParsListSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsListDecl(\n");

        if(FormParsList!=null)
            buffer.append(FormParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsListSingle!=null)
            buffer.append(FormParsListSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsListDecl]");
        return buffer.toString();
    }
}
