package game;

import java.util.ArrayList;

public class Action {

    ArrayList<Item> backpack = new ArrayList<>();


    public void useItem(Item item) {
        backpack.remove(item);
        System.out.println("You used " + item);
    }

    public void takeItem(Item item) {

        backpack.add(item);
        System.out.println("added to backpack: " + item.getName());
    }

    public void showBackpack() {
        System.out.println("In your backpack are: " + backpack);
    }

    public Item findItemInBackpack(String nameItem) {

        for (Item item : backpack) {
            if (nameItem.equals(item.getName())) {
                return item;
            }
        }
        return null;
    }

    public void describeItem(String nameItem) {

        try {
            Item foundedItem = findItemInBackpack(nameItem);
            System.out.println(foundedItem.getDescription());
        } catch (Exception e) {
            System.out.println("You wanted to check '" + nameItem + "' but item doesn't exist");
        }
    }

    public void describeRoom () {
        System.out.println("You see a palm, a chest, bricks and plants ");

    }

    public void callHelp() {
        System.out.println("if you want explore some place you should type 'check [nameOfPlace]");
        System.out.println("if you write 'touch' you will have some interaction with some subject");
        System.out.println("if you write 'take [nameOfItems]' you will take that items");
        System.out.println("if you write 'use [nameOfItems]' you will use this items on specific things");
        System.out.println("if you write 'describe room' you will find what is in room");
        System.out.println("if you write 'check item' and next type name of item, you will check description of it");
    }
}
