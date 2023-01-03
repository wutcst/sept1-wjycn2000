package cn.edu.whut.sept.zuul;

public class HelpCommand extends Command implements ICommand{
    /**
     * 根据输入的第一个单词和第二个单词生成命令
     */
    public HelpCommand() {
        super();
    }

    @Override
    public boolean excute(Game game) {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        game.getParser().showCommands();
        return false;
    }
}
