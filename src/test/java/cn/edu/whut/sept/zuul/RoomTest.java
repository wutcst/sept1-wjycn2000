package cn.edu.whut.sept.zuul;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {

    @Test
    public void getExit() {
        Room testRoom1 = new Room("test room one");
        Room testRoom2 = new Room("test room two");
        testRoom1.setExit("north", testRoom2);
        assertSame(testRoom2, testRoom1.getExit("north"));
        assertNull(testRoom1.getExit("west"));

    }
}