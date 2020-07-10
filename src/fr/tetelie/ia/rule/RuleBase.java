package fr.tetelie.ia.rule;

import java.util.ArrayList;

public class RuleBase {

    public RuleBase()
    {
        rules = new ArrayList<>();
    }

    protected ArrayList<Rule> rules;
    public ArrayList<Rule> getRules()
    {
        return rules;
    }

    public void setRules(ArrayList<Rule> rules)
    {
        for(Rule rule : rules)
        {
            Rule copy = new Rule(rule.name, rule.premises, rule.conclusion);
            this.rules.add(copy);
        }
    }

    public void clearBase()
    {
        rules.clear();
    }

    public void addRule(Rule rule)
    {
        rules.add(rule);
    }

    public void removeRule(Rule rule)
    {
        rules.remove(rule);
    }

}
