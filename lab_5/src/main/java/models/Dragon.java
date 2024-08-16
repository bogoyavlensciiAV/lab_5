package models;

import managers.CollectionManager;
import utilities.Checkable;
import utilities.Essence;
import utilities.IdGenerator;

import java.time.ZonedDateTime;

public class Dragon extends Essence implements Checkable {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer age; //Значение поля должно быть больше 0, Поле не может быть null
    private float weight; //Значение поля должно быть больше 0
    private DragonType type; //Поле может быть null
    private DragonCharacter character; //Поле не может быть null
    private DragonCave cave; //Поле может быть null

    public Dragon(){
        this.setId(IdGenerator.nextId());
        this.setCreationDate(ZonedDateTime.now());
    }

    public Dragon(String name, Coordinates coordinates, Integer age, float weight, DragonType type, DragonCharacter character, DragonCave cave){
        this.setId(IdGenerator.nextId());
        this.setName(name);
        this.setCoordinates(coordinates);
        this.setCreationDate(ZonedDateTime.now());
        this.setAge(age);
        this.setWeight(weight);
        this.setType(type);
        this.setCharacter(character);
        this.setCave(cave);
    }
    //Для сортировки по координатам будем использовать сумму двух координат
    public Long sumCoordinates(){
        return (Long) (getCoordinates().getX() + getCoordinates().getY());
    }

    public Integer getAge(){
        return age;
    }

    @Override
    public String toString(){
        return "id: "+ getId() +", имя: " + getName() + ", координаты: "+ getCoordinates() +", дата создания: "+ getCreationDate() + ", возраст: " + getAge() + ", вес: "+ getWeight() +", тип: "+ getType() +", характер: "+ getCharacter() +", пещера: "+ getCave();
    }
    @Override
    public Integer getId(){
        return id;
    }
    @Override
    public boolean check(){
        if (getName() == null || getName().isEmpty()) return false;
        if (getCoordinates() == null || !getCoordinates().check()) return false;
        if (getCreationDate() == null) return false;
        if (getAge() == null || getAge() <= 0) return false;
        if (getWeight() <= 0) return false;
        if (getType() == null) return false;
        if (getCharacter() == null) return false;
        if (getCave() == null || !getCave().check()) return false;
        return true;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public DragonType getType() {
        return type;
    }

    public void setType(DragonType type) {
        this.type = type;
    }

    public DragonCharacter getCharacter() {
        return character;
    }

    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    public DragonCave getCave() {
        return cave;
    }

    public void setCave(DragonCave cave) {
        this.cave = cave;
    }

    @Override
    public int compareTo(Essence o) {
        return Integer.compare(getName().length(), o.getName().length());
    }
}
