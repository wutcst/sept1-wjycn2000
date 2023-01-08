package cn.edu.whut.sept.zuul;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void hasItem() {
        Game game = new Game();
        Player player = new Player("test_player", game);
        player.getItem(new Item("crystal", "A shinny red stone", 1.0f));
        assertTrue(player.hasItem("crystal"));
        assertFalse(player.hasItem("sword"));

    }
}