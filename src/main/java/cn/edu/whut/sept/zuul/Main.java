/**
 * 该类创建Game的实例并调用它的play方法
 */
package cn.edu.whut.sept.zuul;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Player player = new Player("player1",game);
        game.play();
    }
}
