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
    private String description;
    private HashMap<String, Room> exits;
    private List<Item> itemList;

    /**
     * 创建房间，初始化出口
     * @param description
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
            bld.append(" " + exit);
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


    public List<Item> getItemList(){
        return itemList;
    }
    public void addItem(Item item){
        itemList.add(item);
    }

    public void remove(Item item){
        itemList.remove(item);
    }
}


