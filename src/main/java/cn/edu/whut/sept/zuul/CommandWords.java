/**
 * 该类保存了游戏的有效命令
 * 最初始的命令为go,quit,help
 */
package cn.edu.whut.sept.zuul;

public class CommandWords
{
    private static final String[] validCommands = {
            "go", "quit", "help", "look", "back"
    };

    /**
     * 目前没有初始化任务
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * 判断一个字符串是否是有效命令
     * @param aString 输入字符串
     * @return 如果是有效命令返回真；否则返回假
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        return false;
    }

    /**
     * 显示所有有效命令
     */
    public void showAll()
    {
        for(String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
