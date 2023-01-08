package cn.edu.whut.sept.zuul.command.impl;

import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Player;
import cn.edu.whut.sept.zuul.command.Command;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoCommandTest {

    @Test
    public void execute() {
        Game game = new Game();
        Player player = new Player("testPlayer", game);
        Command command = new Command("go", "north");
        GoCommand goCommand = new GoCommand();
        goCommand.setCommand(command);
        assertFalse(goCommand.execute(game));
    }
}