// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclaration extends MethodDecl {

    private MethodTypeChose MethodTypeChose;
    private MethodName MethodName;
    private MethodAfterType MethodAfterType;
    private VarDeclarationsList VarDeclarationsList;
    private StatementListDecl StatementListDecl;

    public MethodDeclaration (MethodTypeChose MethodTypeChose, MethodName MethodName, MethodAfterType MethodAfterType, VarDeclarationsList VarDeclarationsList, StatementListDecl StatementListDecl) {
        this.MethodTypeChose=MethodTypeChose;
        if(MethodTypeChose!=null) MethodTypeChose.setParent(this);
        this.MethodName=MethodName;
        if(MethodName!=null) MethodName.setParent(this);
        this.MethodAfterType=MethodAfterType;
        if(MethodAfterType!=null) MethodAfterType.setParent(this);
        this.VarDeclarationsList=VarDeclarationsList;
        if(VarDeclarationsList!=null) VarDeclarationsList.setParent(this);
        this.StatementListDecl=StatementListDecl;
        if(StatementListDecl!=null) StatementListDecl.setParent(this);
    }

    public MethodTypeChose getMethodTypeChose() {
        return MethodTypeChose;
    }

    public void setMethodTypeChose(MethodTypeChose MethodTypeChose) {
        this.MethodTypeChose=MethodTypeChose;
    }

    public MethodName getMethodName() {
        return MethodName;
    }

    public void setMethodName(MethodName MethodName) {
        this.MethodName=MethodName;
    }

    public MethodAfterType getMethodAfterType() {
        return MethodAfterType;
    }

    public void setMethodAfterType(MethodAfterType MethodAfterType) {
        this.MethodAfterType=MethodAfterType;
    }

    public VarDeclarationsList getVarDeclarationsList() {
        return VarDeclarationsList;
    }

    public void setVarDeclarationsList(VarDeclarationsList VarDeclarationsList) {
        this.VarDeclarationsList=VarDeclarationsList;
    }

    public StatementListDecl getStatementListDecl() {
        return StatementListDecl;
    }

    public void setStatementListDecl(StatementListDecl StatementListDecl) {
        this.StatementListDecl=StatementListDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodTypeChose!=null) MethodTypeChose.accept(visitor);
        if(MethodName!=null) MethodName.accept(visitor);
        if(MethodAfterType!=null) MethodAfterType.accept(visitor);
        if(VarDeclarationsList!=null) VarDeclarationsList.accept(visitor);
        if(StatementListDecl!=null) StatementListDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodTypeChose!=null) MethodTypeChose.traverseTopDown(visitor);
        if(MethodName!=null) MethodName.traverseTopDown(visitor);
        if(MethodAfterType!=null) MethodAfterType.traverseTopDown(visitor);
        if(VarDeclarationsList!=null) VarDeclarationsList.traverseTopDown(visitor);
        if(StatementListDecl!=null) StatementListDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodTypeChose!=null) MethodTypeChose.traverseBottomUp(visitor);
        if(MethodName!=null) MethodName.traverseBottomUp(visitor);
        if(MethodAfterType!=null) MethodAfterType.traverseBottomUp(visitor);
        if(VarDeclarationsList!=null) VarDeclarationsList.traverseBottomUp(visitor);
        if(StatementListDecl!=null) StatementListDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclaration(\n");

        if(MethodTypeChose!=null)
            buffer.append(MethodTypeChose.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodName!=null)
            buffer.append(MethodName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodAfterType!=null)
            buffer.append(MethodAfterType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclarationsList!=null)
            buffer.append(VarDeclarationsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementListDecl!=null)
            buffer.append(StatementListDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclaration]");
        return buffer.toString();
    }
}
