/**
 * 命令的接口
 */
package cn.edu.whut.sept.zuul;

public interface ICommand {
    /**
     * 所有可执行命令必须实现这个结构
     * @param game
     * @return
     */
    boolean excute(Game game);

}
