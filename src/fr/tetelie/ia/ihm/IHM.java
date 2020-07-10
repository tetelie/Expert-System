package fr.tetelie.ia.ihm;

import fr.tetelie.ia.fact.IFact;
import fr.tetelie.ia.rule.Rule;

import java.util.ArrayList;

public interface IHM {

    int askIntegerValue(String question);
    boolean askBooleanValue(String question);
    void displayFacts(ArrayList<IFact> facts);
    void displayRules(ArrayList<Rule> rules);

}
