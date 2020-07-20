package fr.tetelie.ia;

import fr.tetelie.ia.fact.FactBase;
import fr.tetelie.ia.fact.FactFactory;
import fr.tetelie.ia.fact.IFact;
import fr.tetelie.ia.ihm.IHM;
import fr.tetelie.ia.rule.Rule;
import fr.tetelie.ia.rule.RuleBase;

public class InferencesEngine {

    private FactBase factBase;
    private RuleBase ruleBase;
    private IHM ihm;

    private int hightRuleLevel;

    public InferencesEngine(IHM ihm)
    {
        this.ihm = ihm;
        factBase = new FactBase();
        ruleBase = new RuleBase();
    }

    public int askIntegerValue(String question)
    {
        return ihm.askIntegerValue(question);
    }

    public boolean askBooleanValue(String question)
    {
        return ihm.askBooleanValue(question);
    }

    Rule foundRule(RuleBase ruleBase)
    {
        for(Rule rule : ruleBase.getRules())
        {
            int level = isApplicable(rule);
            if(level != -1)
            {
                hightRuleLevel = level;
                return rule;
            }
        }
        return null;
    }

    int isApplicable(Rule rule)
    {
        int max_level = -1;
        for(IFact f : rule.getPremises())
        {
            IFact found_fact = factBase.searchFact(f.name());
            if(found_fact == null)
            {
                if(f.question() != null)
                {
                    found_fact = FactFactory.fact(f, this);
                    factBase.addFact(found_fact);
                }else{
                    return -1;
                }
            }

            if(!found_fact.value().equals(f.value()))
            {
                return -1;
            }else{
                max_level = Math.max(max_level, found_fact.level());
            }
        }
        return  max_level;
    }

    public void solve()
    {
        RuleBase ruleBase = new RuleBase();
        ruleBase.setRules(this.ruleBase.getRules());

        factBase.clear();

        Rule rule = foundRule(ruleBase);
        while(rule != null)
        {
            IFact newFact = rule.getConclusion();
            newFact.setlevel(hightRuleLevel + 1);
            factBase.addFact(newFact);
            ruleBase.removeRule(rule);

            rule = foundRule(ruleBase);
        }
        ihm.displayFacts(factBase.getFacts());
    }

}
