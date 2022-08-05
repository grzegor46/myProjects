package game;

import java.util.ArrayList;

public class TextGame {

    ArrayList<Item> backpack = new ArrayList<>();

    public void takeItem(Item item) {

        backpack.add(item);
        System.out.println("added to backpack: " + item.name);
    }

    public void showBackpack() {
        System.out.println("In your backpack are: " + backpack);
    }

    private String findItemInBackpack(String nameItem) {
        for (Item item : backpack) {
            if (nameItem.equals(item.name));
            return item.name;
        }
        return "not found";
    }

    public void describeItem(String nameItem) {

        Item foundedItem;
        findItemInBackpack(nameItem);

        System.out.println(item.description);
    }

    public static void main(String[] args) {
        System.out.println("Welcome in escape room");
        TextGame textGame = new TextGame();
        textGame.takeItem(new Item("armor", "armor which was made from dragon scales"));
        textGame.takeItem(new Item("hammer","hammer which was holding by Thor"));
        textGame.describeItem();
        textGame.showBackpack();
    }
}
