/**
 * 该类定义了命令
 * 游戏中用户的输入会被解析成命令，系统根据命令判断要做什么
 */

package cn.edu.whut.sept.zuul;

public class Command
{
    private String commandWord;
    private String secondWord;

    /**
     * 根据输入的第一个单词和第二个单词生成命令
     * @param firstWord 解析出的第一个单词
     * @param secondWord 解析出的第二个单词
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    public Command(){

    }

    public void setCommand(Command c){
        this.commandWord = c.getCommandWord();
        this.secondWord = c.getSecondWord();
    }

    /**
     * 返回命令的第一个单词
     * @return 返回命令单词
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * 返回命令的第二个单词
     * @return 返回第二单词
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * 判断是否是系统未知命令
     * @return 如果命令的第一个单词为空则返回真；否则返回假
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * 判断是否存在第二个单词
     * @return 如果命令存在第二单词则返回真；否则返回假
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}
