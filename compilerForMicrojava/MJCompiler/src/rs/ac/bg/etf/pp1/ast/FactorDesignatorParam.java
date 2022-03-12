// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:38:12


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignatorParam extends Factor {

    private Designator Designator;
    private AfterFactorDesignator AfterFactorDesignator;

    public FactorDesignatorParam (Designator Designator, AfterFactorDesignator AfterFactorDesignator) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.AfterFactorDesignator=AfterFactorDesignator;
        if(AfterFactorDesignator!=null) AfterFactorDesignator.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public AfterFactorDesignator getAfterFactorDesignator() {
        return AfterFactorDesignator;
    }

    public void setAfterFactorDesignator(AfterFactorDesignator AfterFactorDesignator) {
        this.AfterFactorDesignator=AfterFactorDesignator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(AfterFactorDesignator!=null) AfterFactorDesignator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(AfterFactorDesignator!=null) AfterFactorDesignator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(AfterFactorDesignator!=null) AfterFactorDesignator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignatorParam(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AfterFactorDesignator!=null)
            buffer.append(AfterFactorDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignatorParam]");
        return buffer.toString();
    }
}
