package fr.tetelie.ia.fact;

public class BooleanFact implements IFact {

    public BooleanFact(String name, boolean value, int level, String question)
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

    protected boolean value;
    @Override
    public Object value() {
        return null;
    }

    protected int level;
    @Override
    public int level() {
        return 0;
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
        return value ? "" : "!" + name + " (" + level + ")";
    }
}
