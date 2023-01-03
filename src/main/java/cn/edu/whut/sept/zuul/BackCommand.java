package cn.edu.whut.sept.zuul;

public class BackCommand extends Command implements ICommand{
    public BackCommand() {
        super();
    }

    @Override
    public boolean excute(Game game) {
        if(game.getLastRoom()!=null){
            game.setCurrentRoom(game.getLastRoom());
            game.setLastRoom(null);
            System.out.println(game.getCurrentRoom().getLongDescription());
        }else{
            System.out.println("Cannot go back..");
        }
        return false;
    }
}
