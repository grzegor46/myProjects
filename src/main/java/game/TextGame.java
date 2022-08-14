package game;


import java.util.ArrayList;

public class TextGame {

    ArrayList<ItemTemplate> backpack = new ArrayList<>();


    public void takeItem(ItemTemplate itemTemplate) {

        backpack.add(itemTemplate);
        System.out.println("added to backpack: " + itemTemplate.name);
    }

    public void showBackpack() {
        System.out.println("In your backpack are: " + backpack);
    }

    private ItemTemplate findItemInBackpack(String nameItem) {
        for (ItemTemplate itemTemplate : backpack) {
            if (nameItem.equals(itemTemplate.name)) {
                return itemTemplate;
            }
        }
        return null;
    }

    public void describeItem(String nameItem) {

        ItemTemplate foundedItemTemplate = findItemInBackpack(nameItem);

        System.out.println(foundedItemTemplate.getDescription());
    }

    public static void main(String[] args) {
        System.out.println("Welcome in escape room");
        TextGame textGame = new TextGame();

        textGame.takeItem(Items.DragonArmor);
        textGame.takeItem(Items.ThorHammer);
        textGame.describeItem("armor");
        textGame.describeItem("hammer");
        textGame.showBackpack();
    }
}
