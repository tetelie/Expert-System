package fr.tetelie.ia.fact;

import fr.tetelie.ia.InferencesEngine;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FactFactory {

    public static IFact fact(IFact f, InferencesEngine engine)
    {
        try {
            IFact newFact;
            Class c = f.getClass();
            if(c.equals(Class.forName("fr.tetelie.ia.fact.IntegerFact"))){
                int value = engine.askIntegerValue(f.question());
                newFact = new IntegerFact(f.name(), value, 0, null);
            }else{
                boolean value = engine.askBooleanValue(f.question());
                newFact = new BooleanFact(f.name(), value, 0, null);
            }
            return newFact;
        }catch (ClassNotFoundException e)
        {
            Logger.getLogger(FactFactory.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

}
