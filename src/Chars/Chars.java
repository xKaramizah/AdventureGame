package Chars;

public abstract class Chars {
    private String charType;
    private int charID;
    private int damage;
    private int life;
    private int coin;

    public Chars(int charID, String charType, int damage, int life, int coin) {
        this.charType = charType;
        this.charID = charID;
        this.damage = damage;
        this.life = life;
        this.coin = coin;
    }

    public String getCharType() {
        return this.charType;
    }

    public void setCharType(String charType) {
        this.charType = charType;
    }

    public int getCharID() {
        return this.charID;
    }

    public void setCharID(int charID) {
        this.charID = charID;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getCoin() {
        return this.coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
}
