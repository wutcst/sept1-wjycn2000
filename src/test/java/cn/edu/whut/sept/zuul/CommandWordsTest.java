package cn.edu.whut.sept.zuul;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandWordsTest {

    @Test
    public void isCommand() {
        CommandWords commandWords = new CommandWords();
        assertTrue(commandWords.isCommand("take"));
        assertFalse(commandWords.isCommand("swim"));
    }
}