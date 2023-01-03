package cn.edu.whut.sept.zuul;

public class UseCommand extends Command implements ICommand{
    public UseCommand() {
        super();
    }

    @Override
    public boolean excute(Game game) {
        if(getSecondWord()==null){
            System.out.println("use what?");
            return false;
        }

        if(getSecondWord().equals("sword")){
            if(!game.getPlayer().hasItem("sword")){
                System.out.println("You do not have this item..");
                return false;
            }


            if(game.getCurrentRoom().getShortDescription().indexOf("bamboo")!=-1){
                System.out.println("You use sword to cut bamboo and make a boat.");

            }else{
                System.out.println("It doesn't work..");
            }
        }
        else if(getSecondWord().equals("mushroom")){
            if(!game.getPlayer().hasItem("mushroom")){
                System.out.println("You do not have this item..");
                return false;
            }


            if(game.getCurrentRoom().getShortDescription().indexOf("mole")!=-1){
                System.out.println("You give the hungary mole a mushroom");
                System.out.println("The mole gives you a crystal");
                game.getPlayer().loseItem("mushroom");
                game.getPlayer().getItem(new Item("crystal","A shinny blue stone", 1));
            }else{
                System.out.println("It doesn't work");
            }
        }

        return false;
    }
}
