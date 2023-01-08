/**
 * 该类保存了游戏的有效命令
 * 最初始的命令为go,quit,help
 */
package cn.edu.whut.sept.zuul;

public class CommandWords {
    private static final String[] VALID_COMMANDS = {
        "go", "quit", "help", "look", "back",
        "take", "drop", "items", "eat", "use"
    };

    /**
     * initialize.
     */
    public CommandWords() {
        // nothing to do at the moment...
    }

    /**
     * 判断一个字符串是否是有效命令.
     * @param aString 输入字符串
     * @return 如果是有效命令返回真；否则返回假
     */
    public boolean isCommand(String aString) {
        for (String validCommand : VALID_COMMANDS) {
            if (validCommand.equals(aString))
            {
                return true;
            }

        }
        return false;
    }

    /**
     * 显示所有有效命令.
     */
    public void showAll() {
        for(String command: VALID_COMMANDS) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
