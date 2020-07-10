package fr.tetelie.ia;

import fr.tetelie.ia.fact.FactBase;
import fr.tetelie.ia.ihm.IHM;
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

}
