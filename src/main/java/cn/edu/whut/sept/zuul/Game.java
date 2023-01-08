/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 *
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 *
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;


import cn.edu.whut.sept.zuul.command.Command;
import cn.edu.whut.sept.zuul.command.ICommand;

import java.util.LinkedList;
import java.util.List;

public class Game
{
    private Parser parser;
    private Room currentRoom;
    private Room lastRoom;
    private List<Portal> portals;
    private Player player;
    private List<Constraint> constraints;

    /**
     * 创建游戏并初始化内部数据和解析器.
     */
    public Game()
    {
        portals = new LinkedList<>();
        constraints = new LinkedList<>();
        createRooms();
        parser = new Parser();

    }

    /**
     * 获取当前房间
     * @return 当前房间
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * 获取上一次进入的房间
     * @return 上一次进入的房间
     */
    public Room getLastRoom() {
        return lastRoom;
    }

    /**
     * 获取解析器
     * @return
     */
    public Parser getParser() {
        return parser;
    }

    /**
     * 设置上一次进入的房间
     * @param lastRoom 上一次进入的房间
     */
    public void setLastRoom(Room lastRoom) {
        this.lastRoom = lastRoom;
    }

    /**
     * 设置当前房间
     * @param currentRoom 当前房间
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * 获取传送门
     * @return 传送门列表
     */
    public List<Portal> getPortals() {
        return portals;
    }

    /**
     * 添加传送门
     * @param portal 新的传送门
     */
    public void addPortal(Portal portal){
        portals.add(portal);
    }

    /**
     * 设置玩家
     * @param player 玩家
     */
    public void setPlayer(Player player){
        this.player = player;
    }

    /**
     * 获取游玩该游戏的玩家
     * @return 玩家
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * 获取进门限制
     * @return 所有限制
     */
    public List<Constraint> getConstraints() {
        return constraints;
    }

    /**
     * 添加限制
     * @param constraint 限制
     */
    public void addConstraint(Constraint constraint){
        constraints.add(constraint);
    }

    /**
     * 移除限制
     * @param constraint
     */
    public void removeConstraint(Constraint constraint){
        constraints.remove(constraint);
    }

    /**
     * 根据当前房间移除限制
     */
    public void removeConstraint(){
        for(Constraint constraint : getConstraints()){
            if(constraint.getFrom().equals(currentRoom)){
                removeConstraint(constraint);
                break;
            }
        }
    }



    /**
     * 创建所有房间对象并连接其出口用以构建迷宫.
     */
    private void createRooms()
    {
        Room start;
        Room roadside;
        Room lockRoom;
        Room bambooForest;
        Room lake;
        Room mushroomField1;
        Room cave1;
        Room treasureRoom;
        Room cave2;
        Room mushroomField2;
        Room cave3;
        Room hole;

        // create the rooms
        start = new Room("at the start point.");
        roadside = new Room("on a narrow road. You see a lantern hanging by the road.");
        lockRoom = new Room("in a room that has a magic lock. There are 3 holes on it");
        bambooForest = new Room("in a bamboo forest. There is a lake in the west. There is something shinny" +
                " under the lake.");
        lake = new Room("in the middle of lake. You find some crystals under the lake");
        mushroomField1 = new Room("in the middle of a mushroom field. You spot a strange red mushroom");
        cave1 = new Room("in a cave. There is a mole lying on the ground. He is asking for something to eat");
        treasureRoom = new Room("in a treasure room. There are boxes filled with countless coins.");
        cave2 = new Room("in a creepy cave. There is a skeleton lying in the corner. A sword is held tightly in his " +
                "hand");
        mushroomField2 = new Room("in the middle of a lush mushroom field. You spot a strange red mushroom.");
        cave3 = new Room("in a dark cave. The lantern in your hand gives a little light. You see a piece of crystal " +
                "shinning in the darkness");
        hole = new Room("in a hole. The hole leads you to an unknown place.");


        //add portals
        addPortal(new Portal(hole,bambooForest));

        //add constraints
        addConstraint(new Constraint(bambooForest, lake));
        addConstraint(new Constraint(lockRoom, treasureRoom));
        addConstraint(new Constraint(mushroomField2, cave3));
        // add items
        roadside.addItem(new Item("lantern","It provides a vague light",6));
        lake.addItem(new Item("crystal","A shinny red stone", 1));
        mushroomField1.addItem((new Item("mushroom","A strange red mushroom", 1)));
        cave2.addItem(new Item("sword","It has sharp blade",2));
        mushroomField2.addItem(new Item("mushroom","A strange red mushroom",1));
        cave3.addItem(new Item("crystal","A shinny green stone", 1));


        // initialise room exits
        start.setExit("north", roadside);
        roadside.setExit("south", start);
        roadside.setExit("north", lockRoom);
        lockRoom.setExit("south",roadside);
        lockRoom.setExit("west",bambooForest);
        lockRoom.setExit("east",cave2);
        lockRoom.setExit("north",treasureRoom);
        bambooForest.setExit("west", lake);
        bambooForest.setExit("east", lockRoom);
        bambooForest.setExit("north", mushroomField1);
        lake.setExit("east",bambooForest);
        mushroomField1.setExit("south", bambooForest);
        mushroomField1.setExit("north",cave1);
        cave1.setExit("south",mushroomField1);
        treasureRoom.setExit("south",lockRoom);
        cave2.setExit("west",lockRoom);
        cave2.setExit("north",mushroomField2);
        mushroomField2.setExit("south",cave2);
        mushroomField2.setExit("east",cave3);
        cave3.setExit("west",mushroomField2);
        cave3.setExit("north",hole);

        currentRoom = start;  // start game outside
        lastRoom = null;
    }

    /**
     *  游戏主控循环，直到用户输入退出命令后结束整个程序.
     */
    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * 向用户输出欢迎信息.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * 执行用户输入的游戏指令.
     * @param command 待处理的游戏指令，由解析器从用户输入内容生成.
     * @return 如果执行的是游戏结束指令，则返回true，否则返回false.
     */
    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        String packageName = "cn.edu.whut.sept.zuul.command.impl.";
        StringBuilder bld = new StringBuilder();
        bld.append(packageName);
        bld.append(Parser.upperCaseFirst(commandWord));
        bld.append("Command");


        try {
            Command c = (Command) Class.forName(bld.toString()).newInstance();
            c.setCommand(command);
            ICommand iCommand = (ICommand)c;
            wantToQuit = iCommand.execute(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return wantToQuit;
    }

}