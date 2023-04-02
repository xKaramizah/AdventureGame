package Weapons;

public class Weapons {
    private String type;
    private int id;
    private int damage;
    private int cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Weapons(String type, int id, int damage, int cost) {
        this.type = type;
        this.id = id;
        this.damage = damage;
        this.cost = cost;
    }

    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }

}
