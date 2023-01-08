/**
 * 该类用于限制某个房间通向另一个房间
 */
package cn.edu.whut.sept.zuul;

public class Constraint {
    private final Room from;
    private final Room to;

    /**
     * 创建限制
     * @param from 从这个房间
     * @param to 到另一个房间
     */
    public Constraint(Room from, Room to) {
        this.from = from;
        this.to = to;
    }

    /**
     * 获取从房间
     * @return 从房间
     */
    public Room getFrom() {
        return from;
    }

    /**
     * 获取到房间
     * @return 到房间
     */
    public Room getTo() {
        return to;
    }
}
