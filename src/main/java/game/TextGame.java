package game;


import java.util.Scanner;

public class TextGame {

    Action action = new Action();
    Scanner scanner = new Scanner(System.in);


    public void startGame () {

    boolean isPalmCaseCompleted = false;
    int touched = 0;

    System.out.println(" \nIf you need help, you can just type 'help'");

    while(true) {
        System.out.println("What do you wanna check?");
        String choice = scanner.nextLine();

        if(choice.equals("check help")) {
            action.callHelp();
        }

        if(choice.equals("check room")) {
            action.describeRoom();
        }

        if(choice.equals("check backpack")) {
            action.showBackpack();
        }


        if (choice.equals("check item")) {
            System.out.println("Which item do you wanna check?");
            action.showBackpack();
            choice = scanner.nextLine();
            action.describeItem(choice);
        }

        if (choice.equals("check palm")) {
            System.out.println("You see a palm, it has some coconuts");
            System.out.println("what do you want to do?");
            choice = scanner.nextLine();
            if(choice.equals("touch")) {
                touched++;
                if(isPalmCaseCompleted) {
                    System.out.println("You touched a palm, but nothing happened");
                }
            }

            if(touched == 1) {
                System.out.println("You touched a palm, but nothing happened");
            }
//            TODO: check palm, 2x touch, 1x nothing, check palm, take piece of map --> refactor
            if(touched >= 2 && choice.equals("take " + Items.pieceOfMap.getName())) {
                if (isPalmCaseCompleted) {
                    System.out.println("You see only crashed coconuts, because you have already taken content");
                } else {
                    action.takeItem(Items.pieceOfMap);
                    isPalmCaseCompleted = true;
                    System.out.println("You added " + Items.pieceOfMap.getName() + " to your backpack");
                }
                System.out.println("you left that a piece of map ");
            }
            if (touched == 2) {
                System.out.println("You touched a palm. One of the coconuts fell and crashed in half and inside was some a 'piece of map'");
                System.out.println("what do you want to do?");
                choice = scanner.nextLine();
                if (choice.equals("take " + Items.pieceOfMap.getName())) {
                    action.takeItem(Items.pieceOfMap);
                    isPalmCaseCompleted = true;
                    System.out.println("You added " + Items.pieceOfMap.getName() + " to your backpack");

                } else {
                    System.out.println("you left that a piece of map ");
                }
            }
            if(touched > 2) {
                if (isPalmCaseCompleted) {
                    System.out.println("You see only crashed coconuts, because you have already taken content");
                } else {
                    System.out.println("You came back to palm and see piece of map?");
                    System.out.println("what do you want to do?");
                    choice = scanner.nextLine();
                    if (choice.equals("take " + Items.pieceOfMap.getName())) {
                        action.takeItem(Items.pieceOfMap);
                        isPalmCaseCompleted = true;
                        System.out.println("You added " + Items.pieceOfMap.getName() + " to your backpack");
                    } else {
                        System.out.println("you left that a piece of map ");
                    }
                }
            }


            }

        }

//        if (choice.equals("bricks")) {
//            System.out.println("You see a few red bricks, nothing special");
//
//            if(isPalmCaseCompleted) {
//
//            }
//        }


    }




    public static void main(String[] args) {
        System.out.println("Welcome in escape room");
        TextGame textGame = new TextGame();
        textGame.startGame();

//        textGame.action.takeItem(Items.ThorHammer);
//        textGame.action.describeItem("hammer");
//        textGame.action.describeItem("fire sword");
//        textGame.action.showBackpack();
//        textGame.action.describeRoom();


    }
}
