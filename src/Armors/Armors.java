package Armors;

public class Armors {
    private String type;
    private int id;
    private int block;
    private int cost;

    public Armors(String type, int id, int block, int cost) {
        this.type = type;
        this.id = id;
        this.block = block;
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
