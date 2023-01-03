package cn.edu.whut.sept.zuul;

public class QuitCommand extends Command implements ICommand{
    /**
     * 根据输入的第一个单词和第二个单词生成命令
     */
    public QuitCommand() {
        super();
    }

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
