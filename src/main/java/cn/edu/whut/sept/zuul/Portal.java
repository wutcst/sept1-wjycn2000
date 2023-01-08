/**
 * Portal类。为游戏地图添加传送门。
 */
package cn.edu.whut.sept.zuul;

public class Portal {
    private final Room triggerRoom;
    private final Room targetRoom;

    /**
     * 传送门
     * @param triggerRoom 进入该房间触发传送门
     * @param targetRoom 传送的目的地
     */
    public Portal(Room triggerRoom, Room targetRoom) {
        this.triggerRoom = triggerRoom;
        this.targetRoom = targetRoom;
    }

    /**
     * 获得传送触发房间
     * @return 触发房间
     */
    public Room getTriggerRoom() {
        return triggerRoom;
    }

    /**
     * 获得传送目的地
     * @return 传送目的地
     */
    public Room getTargetRoom() {
        return targetRoom;
    }
}
