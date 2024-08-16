package models;

public enum DragonType {
    WATER(0),
    UNDERGROUND(1),
    AIR(2);
    private final int typeCode;

    DragonType(int typeCode) {
        this.typeCode = typeCode;
    }

    public int getTypeCode() {
        return this.typeCode;
    }
    @Override
    public String toString(){
        return this.name() + " - " + this.typeCode;
    }
}
