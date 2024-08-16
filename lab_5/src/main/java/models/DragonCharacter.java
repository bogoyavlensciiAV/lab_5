package models;

public enum DragonCharacter {
    WISE(0),
    EVIL(1),
    GOOD(2),
    CHAOTIC(3);
    private final int characterCode;

    DragonCharacter(int characterCode) {
        this.characterCode = characterCode;
    }

    public int getCharacterCode() {
        return this.characterCode;
    }
    @Override
    public String toString(){
        return this.name() + " - " + this.characterCode;
    }
}
