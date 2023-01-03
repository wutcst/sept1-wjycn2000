package cn.edu.whut.sept.zuul;

import java.util.List;

public class EatCommand extends Command implements ICommand{
    public EatCommand() {
        super();
    }

    @Override
    public boolean excute(Game game) {
        if(getSecondWord()==null){
            System.out.println("eat what?");
            return false;
        }

        if(getSecondWord().equals("cookie")){
            List<Item> itemList = game.getPlayer().getItemList();
            for(Item item : itemList){
                if(item.getName().equals("cookie")){
                    game.getPlayer().setMaxWeight(game.getPlayer().getMaxWeight()+5.0f);
                    game.getPlayer().loseItem(item);
                    System.out.println("You eat the cookie..");
                    System.out.println("You can carry " + game.getPlayer().getMaxWeight()+"kg now!");
                    return false;
                }
            }
            System.out.println("You do not have a cookie..");
        }
        return false;
    }
}
