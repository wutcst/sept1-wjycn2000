/**
 * Quit命令，退出游戏
 */
package cn.edu.whut.sept.zuul;

import cn.edu.whut.sept.zuul.command.ICommand;

public class QuitCommand extends Command implements ICommand {
    public QuitCommand() {
        super();
    }

    /**
     * 如果输入了第二个单词，询问是否退出；否则返回退出信号
     * @param game
     * @return
     */
    @Override
    public boolean excute(Game game) {
        if(hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

}
