package fr.tetelie.ia.fact;

public interface IFact {

    String name();
    Object value();
    int level();
    String question();

    void setlevel(int l);

}
