package models;
import utilities.Checkable;

public class DragonCave implements Checkable{
    private float depth;
    private Double numberOfTreasures; //Поле может быть null, Значение поля должно быть больше 0
    public DragonCave(float depth, Double numberOfTreasures) {
        this.depth = depth;
        this.numberOfTreasures = numberOfTreasures;
    }
    public boolean checkNumberOfTreasures(Double numberOfTreasures){
        if (numberOfTreasures == null || numberOfTreasures <=0){
            return false;
        } else {
            return true;
        }
    }
    @Override
    public String toString(){
        return "глубина - "+ depth +"; кол-во_сокровищ - "+numberOfTreasures;
    }

    @Override
    public boolean check() {
        return checkNumberOfTreasures(this.numberOfTreasures);
    }
}

