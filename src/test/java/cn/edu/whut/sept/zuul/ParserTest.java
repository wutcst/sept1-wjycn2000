package cn.edu.whut.sept.zuul;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void upperCaseFirst() {
        assertEquals("Take", Parser.upperCaseFirst("take"));
    }
}