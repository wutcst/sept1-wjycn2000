package cn.edu.whut.sept.zuul;

public class GoCommand extends Command implements ICommand{
    /**
     * 根据输入的第一个单词和第二个单词生成命令
     */
    public GoCommand() {
        super();
    }

    @Override
    public boolean excute(Game game) {
        if(!hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return false;
        }

        String direction = getSecondWord();

        // Try to leave current room.
        Room currentRoom = game.getCurrentRoom();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
        return false;
    }
}
