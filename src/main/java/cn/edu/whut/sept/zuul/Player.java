/**
 * Player类。存储玩家信息的类，包括玩家的姓名，当前所在房间，能携带的最大重量，当前重量，物品栏。
 * 使用拾起和丢弃物品命令，玩家可以获取物品和失去物品
 */
package cn.edu.whut.sept.zuul;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private String name;
    private Room currentRoom;
    private float maxWeight;
    private float weight;
    private List<Item> itemList;

    /**
     * 初始化玩家信息，默认最大承重10kg
     * @param name 玩家姓名
     * @param game 游戏
     */
    public Player(String name, Game game){
        this.name = name;
        this.currentRoom = game.getCurrentRoom();
        this.maxWeight = 10.0f;
        this.itemList = new LinkedList<>();
    }

    /**
     * 获取玩家当前承重
     * @return 当前承重
     */
    public float getWeight(){
        return weight;
    }

    /**
     * 获取玩家最大承重
     * @return 最大承重
     */
    public float getMaxWeight(){
        return maxWeight;
    }

    /**
     * 改变最大承重
     * @param maxWeight 新的最大承重
     */
    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * 改变当前承重
     * @param weight 新的承重
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * 更新玩家当前所在房间
     * @param currentRoom 当前房间
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * 获取玩家当前所在房间
     * @return 当前房间
     */
    public Room getCurrentRoom(){
        return currentRoom;
    }

    /**
     * 获取玩家姓名
     * @return 玩家姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 获取玩家物品栏
     * @return 物品栏信息
     */
    public List<Item> getItemList() {
        return itemList;
    }

    /**
     * 添加物品到物品栏
     * @param item 新增物品
     */
    public void getItem(Item item){
        itemList.add(item);
    }

    /**
     * 从物品栏中移除物品
     * @param item 要移除的物品
     */
    public void loseItem(Item item){
        itemList.remove(item);
    }
}
