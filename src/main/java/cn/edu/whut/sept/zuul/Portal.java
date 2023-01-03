package cn.edu.whut.sept.zuul;

public class Portal {
    private Room triggerRoom;
    private Room targetRoom;

    public Portal(Room triggerRoom, Room targetRoom) {
        this.triggerRoom = triggerRoom;
        this.targetRoom = targetRoom;
    }

    public Room getTriggerRoom() {
        return triggerRoom;
    }

    public Room getTargetRoom() {
        return targetRoom;
    }
}
