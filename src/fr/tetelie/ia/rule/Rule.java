package fr.tetelie.ia.rule;

import fr.tetelie.ia.fact.IFact;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Rule {

    public Rule(String name, ArrayList<IFact> premises, IFact conclusion)
    {
        this.name = name;
        this.premises = premises;
        this.conclusion = conclusion;
    }

    protected ArrayList<IFact> premises;
    public ArrayList<IFact> getPremises()
    {
        return premises;
    }

    public void setPremises(ArrayList<IFact> premises)
    {
        this.premises = premises;
    }

    protected IFact conclusion;
    public IFact getConclusion()
    {
        return conclusion;
    }

    public void SetConclusion(IFact conclusion)
    {
        this.conclusion = conclusion;
    }

    protected String name;
    public String getName()
    {
        return name;
    }

    protected void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        String str = name + " : IF (";

        StringJoiner sj = new StringJoiner("AND");
        for(IFact fact : premises)
        {
            sj.add(fact.toString());
        }

        str += sj.toString() + ") THEN " + conclusion.toString();
        return str;
    }
}
