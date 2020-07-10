package fr.tetelie.ia;

import fr.tetelie.ia.fact.IFact;
import fr.tetelie.ia.ihm.IHM;
import fr.tetelie.ia.rule.Rule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Application implements IHM {

    public static void main(String[] args) {

    }

    @Override
    public int askIntegerValue(String question) {
        System.out.println(question);

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return Integer.decode(reader.readLine());
        }catch (IOException e)
        {
            return 0;
        }
    }

    @Override
    public boolean askBooleanValue(String question) {
        System.out.println(question);

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String answer = reader.readLine();
            if(answer == "yes" || answer == "oui")
            {
                return true;
            }else{
                return false;
            }
        }catch (IOException e)
        {
            return false;
        }
    }

    @Override
    public void displayFacts(ArrayList<IFact> facts) {
        String res = "Solution(s) Found: \n";
        facts.sort(null);
        Collections.sort(facts, (IFact f1, IFact f2) ->
        {
            if(f1.level() == f2.level())
            {
                return 0;
            }else if(f1.level() > f2.level())
            {
                return -1;
            }else{
                return 1;
            }
        });

        for(IFact f : facts)
        {
            if(f.level() != 0)
            {
                res += f.toString() + "\n";
            }
        }
        System.out.println(res);
    }

    @Override
    public void displayRules(ArrayList<Rule> rules) {
        String res = "";
        for(Rule r : rules)
        {
            res += r.toString() + "\n";
        }
        System.out.println(res);
    }
}
