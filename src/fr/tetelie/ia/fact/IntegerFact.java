package fr.tetelie.ia.fact;

public class IntegerFact implements IFact {

    public IntegerFact(String name, int value, int level, String question)
    {
        this.name = name;
        this.value = value;
        this.level = level;
        this.question = question;
    }

    protected String name;
    @Override
    public String name() {
        return name;
    }

    protected int value;
    @Override
    public Object value() {
        return value;
    }

    protected int level;
    @Override
    public int level() {
        return level;
    }

    protected String question;
    @Override
    public String question() {
        return question;
    }

    @Override
    public void setlevel(int l) {
        level = l;
    }

    @Override
    public String toString() {
        return name + "=" + value + " (" + level + ")";
    }
}
