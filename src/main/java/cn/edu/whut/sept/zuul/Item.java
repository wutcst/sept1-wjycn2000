package cn.edu.whut.sept.zuul;

public class Item {
    private String name;
    private String description;
    private float weight;

    public Item(String name, String description, float weight) {
        this.name = name;
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
