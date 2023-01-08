/**
 * 帮助命令
 */
package cn.edu.whut.sept.zuul.command.impl;

import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.command.Command;
import cn.edu.whut.sept.zuul.command.ICommand;

public class HelpCommand extends Command implements ICommand {
    /**
     * 根据输入的第一个单词和第二个单词生成命令
     */
    public HelpCommand() {
        super();
    }

    /**
     * 执行此命令输出帮助信息，和所有有效命令
     * @param game
     * @return 假
     */
    @Override
    public boolean execute(Game game) {
        System.out.println("You are a explorer.");
        System.out.println("You are exploring a mysterious cave.");
        System.out.println();
        System.out.println("Your command words are:");
        game.getParser().showCommands();
        return false;
    }
}
