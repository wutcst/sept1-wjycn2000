/**
 * 该类是物品类，游戏中的物品都是该类的实例。
 */
package cn.edu.whut.sept.zuul;

public class Item {
    private String name;
    private String description;
    private float weight;

    /**
     * 创建物品对象
     * @param name 物品名
     * @param description 物品描述
     * @param weight 物品重量
     */
    public Item(String name, String description, float weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }


    /**
     * 获取物品名
     * @return 物品名
     */
    public String getName() {
        return name;
    }

    /**
     * 获取物品描述
     * @return 物品描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 获取物品重量
     * @return 物品重量
     */
    public float getWeight() {
        return weight;
    }
}
