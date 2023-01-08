package cn.edu.whut.sept.zuul.command.impl;

import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.command.Command;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuitCommandTest {

    @Test
    public void execute() {
        Game game = new Game();
        Command command = new Command("quit", null);
        QuitCommand quitCommand = new QuitCommand();
        quitCommand.setCommand(command);
        assertTrue(quitCommand.execute(game));
    }
}