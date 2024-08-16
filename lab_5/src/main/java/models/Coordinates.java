package models;
import exceptions.InappropriateArgumentException;
import utilities.Checkable;

public class Coordinates implements Checkable{
    private int x; //Максимальное значение поля: 492
    private Long y; //Поле не может быть null

    public Coordinates(Integer x, Long y) {
        this.x = x;
        this.y = y;
    }
    public static boolean checkX(int x){
        return x <= 492;
    }
    public static boolean checkY(Long y){
        return y != null;
    }
    public int getX(){
        return x;
    }
    public Long getY(){
        return y;
    }
    @Override
    public String toString(){
        return "x - "+x +";y - "+y;
    }

    @Override
    public boolean check() {
        return checkX(this.x) && checkY(this.y);
    }
}
