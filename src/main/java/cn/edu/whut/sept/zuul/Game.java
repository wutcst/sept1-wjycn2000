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


import java.util.LinkedList;
import java.util.List;

public class Game
{
    private Parser parser;
    private Room currentRoom;
    private Room lastRoom;
    private List<Portal> portals;
    private Player player;

    /**
     * 创建游戏并初始化内部数据和解析器.
     */
    public Game()
    {
        portals = new LinkedList<>();
        createRooms();
        parser = new Parser();

    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room getLastRoom() {
        return lastRoom;
    }

    public Parser getParser() {
        return parser;
    }

    public void setLastRoom(Room lastRoom) {
        this.lastRoom = lastRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public List<Portal> getPortals() {
        return portals;
    }

    public void addPortal(Portal portal){
        portals.add(portal);
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * 创建所有房间对象并连接其出口用以构建迷宫.
     */
    private void createRooms()
    {
        Room outside;
        Room theater;
        Room pub;
        Room lab;
        Room office;

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");


        //add portals
        addPortal(new Portal(theater,lab));

        // add items
        outside.addItem(new Item("shovel","A tool for digging",10));
        outside.addItem(new Item("lantern","It provides a vague light",2));

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;  // start game outside
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
        String pacageName = "cn.edu.whut.sept.zuul.";
        StringBuilder bld = new StringBuilder();
        bld.append(pacageName);
        bld.append(upperCaseFirst(commandWord));
        bld.append("Command");


        try {
            Command c = (Command) Class.forName(bld.toString()).newInstance();
            c.setCommand(command);
            ICommand iCommand = (ICommand)c;
            wantToQuit = iCommand.excute(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return wantToQuit;
    }

    public static String upperCaseFirst(String val) {
        char[] arr = val.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        return new String(arr);
    }
}