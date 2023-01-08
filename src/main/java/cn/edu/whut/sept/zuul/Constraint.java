/**
 * 该类用于限制某个房间通向另一个房间
 */
package cn.edu.whut.sept.zuul;

public class Constraint {

    /**
     * 从哪个房间.
     */
    private final Room from;

    /**
     * 到哪个房间.
     */
    private final Room to;

    /**
     * 创建限制.
     * @param fromRoom 从这个房间
     * @param toRoom 到另一个房间
     */
    public Constraint(final Room fromRoom, final Room toRoom) {
        this.from = fromRoom;
        this.to = toRoom;
    }

    /**
     * 获取从房间.
     * @return 从房间
     */
    public Room getFrom() {
        return from;
    }

    /**
     * 获取到房间.
     * @return 到房间
     */
    public Room getTo() {
        return to;
    }
}
