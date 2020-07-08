package fr.tetelie.ia.fact;

import java.util.ArrayList;

public class FactBase {

    public FactBase()
    {
        facts = new ArrayList<>();
    }

    protected ArrayList<IFact> facts;
    public ArrayList<IFact> getFacts()
    {
        return facts;
    }

    public void clear()
    {
        facts.clear();
    }

    public void addFact(IFact fact)
    {
        facts.add(fact);
    }

    public IFact searchFact(String name)
    {
        return facts.stream().filter(f -> f.name().equals(name)).findFirst().orElse(null);
    }

    public Object getFactValue(String name)
    {
        if(searchFact(name) != null)
        {
            return searchFact(name).value();
        }else{
            return null;
        }
    }

}
