/**
 * 该类是物品类，游戏中的物品都是该类的实例。
 */
package cn.edu.whut.sept.zuul;

public class Item {

    /**
     * 灯笼重量.
     */
    public static final float LANTERN_WEIGHT = 6.0f;

    /**
     * 物品名.
     */
    private final String name;
    /**
     * 物品描述.
     */
    private final String description;
    /**
     * 物品重量.
     */
    private final float weight;

    /**
     * 创建物品对象.
     * @param aName 物品名
     * @param aWeight 物品描述
     * @param aDescription 物品重量
     */
    public Item(final String aName, final String aDescription,
        final float aWeight) {
        this.name = aName;
        this.description = aDescription;
        this.weight = aWeight;
    }


    /**
     * 获取物品名.
     * @return 物品名
     */
    public String getName() {
        return name;
    }

    /**
     * 获取物品描述.
     * @return 物品描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 获取物品重量.
     * @return 物品重量
     */
    public float getWeight() {
        return weight;
    }
}
