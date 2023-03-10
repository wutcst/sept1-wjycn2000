/**
 * Use命令
 */
package cn.edu.whut.sept.zuul.command.impl;

import cn.edu.whut.sept.zuul.Constraint;
import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Item;
import cn.edu.whut.sept.zuul.command.Command;
import cn.edu.whut.sept.zuul.command.ICommand;

import java.util.List;

public class UseCommand extends Command implements ICommand {
    @SuppressWarnings("unused")
    public UseCommand() {
        super();
    }

    /**
     * 使用物品，触发效果
     * @return 假
     */
    @SuppressWarnings("unused")
    @Override
    public boolean execute(Game game) {
        if(getSecondWord()==null){
            System.out.println("use what?");
            return false;
        }

        switch (getSecondWord()) {
            case "sword":
                if (!game.getPlayer().hasItem("sword")) {
                    System.out.println("You do not have this item..");
                    return false;
                }


                if (game.getCurrentRoom().getShortDescription().contains("bamboo")) {
                    System.out.println("You use sword to cut bamboo and make a boat.");
                    for (Constraint constraint : game.getConstraints()) {
                        if (constraint.getFrom().equals(game.getCurrentRoom())) {
                            game.removeConstraint(constraint);
                            break;
                        }
                    }

                } else {
                    System.out.println("It doesn't work..");
                }
                break;
            case "mushroom":
                if (!game.getPlayer().hasItem("mushroom")) {
                    System.out.println("You do not have this item..");
                    return false;
                }


                if (game.getCurrentRoom().getShortDescription().contains("mole")) {
                    System.out.println("You give the hungary mole a mushroom");
                    System.out.println("The mole gives you a crystal");
                    game.getPlayer().loseItem("mushroom");
                    game.getPlayer().getItem(new Item("crystal", "A shinny blue stone", 1));
                } else {
                    System.out.println("It doesn't work");
                }
                break;
            case "crystal":
                int numberOfCrystals = 0;
                List<Item> itemList = game.getPlayer().getItemList();
                for (Item item : itemList) {
                    if (item.getName().equals("crystal")) {
                        numberOfCrystals++;
                    }
                }
                if (numberOfCrystals < 3) {
                    System.out.println("collect more crystals..");
                    return false;
                } else {
                    System.out.println("You place the crystals in the lock. The door opens.");
                    for (Constraint constraint : game.getConstraints()) {
                        if (constraint.getFrom().equals(game.getCurrentRoom())) {
                            game.removeConstraint(constraint);
                            break;
                        }
                    }

                }
                break;
            case "lantern":
                if (!game.getPlayer().hasItem("lantern")) {
                    System.out.println("You do no have this item..");
                    return false;
                }

                if (game.getCurrentRoom().getShortDescription().contains("lush")) {
                    System.out.println("You take out the lantern. It lets you see things in the darkness.");
                    game.removeConstraint();
                } else {
                    System.out.println("It doesn't work..");
                }
                break;
        }

        return false;
    }

}
