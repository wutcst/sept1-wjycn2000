/**
 * 该类是游戏中的房间类
 * 每个房间有一些出口和一段描述
 */
package cn.edu.whut.sept.zuul;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.HashMap;

public class Room
{
    private final String description;
    private final HashMap<String, Room> exits;
    private final List<Item> itemList;

    /**
     * 创建房间，初始化出口
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
        itemList = new LinkedList<>();
    }

    /**
     * 设置房间的出口
     * @param direction 门的方位
     * @param neighbor 门通向的房间
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     * 返回简短描述
     * @return 描述
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * 返回详细描述
     * @return 详细描述
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * 返回房间的所有出口方向
     * @return 出口
     */
    private String getExitString()
    {
        StringBuilder bld = new StringBuilder();
        bld.append("Exits:");
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            bld.append(" ").append(exit);
        }
        return bld.toString();
    }

    /**
     * 返回房间某个方向上的出口
     * @param direction 指定方向
     * @return 此方向上的出口，如果存在返回连通房间，否则返回null
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }


    /**
     * 获得房间的物品列表
     * @return 物品列表
     */
    public List<Item> getItemList(){
        return itemList;
    }

    /**
     * 添加物品到房间
     * @param item 物品
     */
    public void addItem(Item item){
        itemList.add(item);
    }

    /**
     * 移除房间的物品
     * @param item 物品
     */
    public void removeItem(Item item){
        itemList.remove(item);
    }
}


