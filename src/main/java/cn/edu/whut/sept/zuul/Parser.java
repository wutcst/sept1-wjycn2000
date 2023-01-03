/**
 * 该类是游戏的解析器
 * 本游戏通过用户向控制台输入命令来游玩，因此需要解析器
 * 主要作用是将用户输入解析为命令的格式
 */
package cn.edu.whut.sept.zuul;

import cn.edu.whut.sept.zuul.command.Command;

import java.util.Scanner;

public class Parser
{
    private CommandWords commands;
    private Scanner reader;

    /**
     * 初始化游戏的命令语句和输入端口
     */
    public Parser()
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * 从输入窗口得到一行字符串，将它解析为命令单词+第二单词，以命令的形式返回
     * @return 如果命令单词属于游戏允许的命令，返回完整的命令；否则，返回命令单词为空的命令
     */
    public Command getCommand()
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }


        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2);
        }
    }

    /**
     * 显示所有允许的命令
     */
    public void showCommands()
    {
        commands.showAll();
    }
}
