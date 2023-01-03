package cn.edu.whut.sept.zuul;

public class Item {
    private String description;
    private float weight;

    public Item(String description, float weight) {
        this.description = description;
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public float getWeight() {
        return weight;
    }
}
