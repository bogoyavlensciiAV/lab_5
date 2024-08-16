package utilities;

import models.Dragon;

public abstract class Essence implements Comparable<Essence>{
    private String name;
    public String getName(){
        return this.name;
    }
    public abstract Integer getId();

    public abstract int compareTo(Essence o);
}
