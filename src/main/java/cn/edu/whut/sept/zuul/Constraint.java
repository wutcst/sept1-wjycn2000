package cn.edu.whut.sept.zuul;

public class Constraint {
    private Room from;
    private Room to;

    public Constraint(Room from, Room to) {
        this.from = from;
        this.to = to;
    }

    public Room getFrom() {
        return from;
    }

    public Room getTo() {
        return to;
    }
}
