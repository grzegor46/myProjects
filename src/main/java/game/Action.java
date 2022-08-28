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
            System.out.println("You wanted check '" + nameItem + "' but item doesn't exist");
        }

    }

    public void describeRoom () {
        System.out.println("You see a palm,  a chest, some bricks on the floor and a table");

//        trzeba obejrzec stol, żeby znalezc latarke, które potem mozna wykorzystać podświetlając mapę i znależć skarb.

//        w cegle będzie trzeba użyć młotka, ponieważ w środku będzie kod do skrzyni
//        mapa jest niekompletna, brakuje kawalka jej, aby byla w calosci.
//        dopiero po odczytaniu w kokosie mapy jest napis aby rozlupac cegly.
//        palme bedzie trzeba  2-3 razy poruszyc aby spadl kokos, w ktorym jest  brakujaca czesc mapy
//        skrzynia ma klodke w ktorej trzeba bedzie wpisac kod (kod bedzie generowany losowo), w skrzyni jest mapa
//
//        po zdobyciu mapy można iść odszukać skarb - > koniec gry

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
