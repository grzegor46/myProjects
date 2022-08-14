package game;

import java.util.ArrayList;

public class Action {

    ArrayList<ItemTemplate> backpack = new ArrayList<>();


    public void takeItem(ItemTemplate itemTemplate) {

        backpack.add(itemTemplate);
        System.out.println("added to backpack: " + itemTemplate.getName());
    }

    public void showBackpack() {
        System.out.println("In your backpack are: " + backpack);
    }

    private ItemTemplate findItemInBackpack(String nameItem) {
        for (ItemTemplate itemTemplate : backpack) {
            if (nameItem.equals(itemTemplate.getName())) {
                return itemTemplate;
            }
        }
        return null;
    }

    public void describeItem(String nameItem) {

        try {
            ItemTemplate foundedItemTemplate = findItemInBackpack(nameItem);
            System.out.println(foundedItemTemplate.getDescription());
        } catch (Exception e) {
            System.out.println(  "You wanted check '" + nameItem + "' but item doesn't exist");
        }

    }
}
