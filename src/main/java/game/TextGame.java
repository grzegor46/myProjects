package game;


import java.util.Scanner;

public class TextGame {

    Action action = new Action();
    Scanner scanner = new Scanner(System.in);


    public void startGame () {

    boolean isPalmSectionCompleted = false;
    boolean hammerInBackPack = false;
    boolean isPlantsSectionCompleted = false;
    boolean isBricksSectionCompleted = false;
    boolean coconutsDroped = false;
//        TODO: coconuts in backpack?
    boolean coconutsInBackPack = false;
    int checkPalm = 0;
    int checkPlants = 0;
    int touched = 0;
//        boolean isPalmSectionCompleted = true;
//        boolean hammerInBackPack = true;
//        boolean isPlantsSectionCompleted = true;
//        boolean coconutsDroped = true;
//        boolean coconutsInBackPack = false;
//        int checkPalm = 0;
//        int checkPlants = 0;
//        int touched = 0;

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

//      ## PALM SECTION

        if (choice.equals("check palm")) {
            checkPalm++;
            if(touched >= 2 && !coconutsInBackPack && checkPalm >= 3) {
                if (isPalmSectionCompleted) {
                    System.out.println("You see only crashed coconuts, because you have already taken content");
                } else {
                    System.out.println("You came back to palm and see piece of map");
                    System.out.println("what do you want to do?");
                    choice = scanner.nextLine();
                    if (choice.equals("take " + ItemsList.pieceOfMap.getName())) {
                        action.takeItem(ItemsList.pieceOfMap);
                        coconutsInBackPack = true;
                        isPalmSectionCompleted = true;
                        System.out.println("You added " + ItemsList.pieceOfMap.getName() + " to your backpack");
                    } else {
                        System.out.println("you left that a piece of map ");
                        coconutsInBackPack = false;
                    }
                }
            } else {
                System.out.println("You see a palm, it has some coconuts");
                System.out.println("what do you want to do?");
                choice = scanner.nextLine();
            }

            if(choice.equals("touch")) {
                touched++;
                if(isPalmSectionCompleted) {
                    System.out.println("You touched a palm, but nothing happened");
                }

            }

            if(touched == 1) {
                System.out.println("You touched a palm, but nothing happened");
            }

            if (touched == 2 && !coconutsDroped) {
                System.out.println("You touched a palm. One of the coconuts fell and crashed in half and inside was some a 'piece of map'");
                coconutsDroped = true;
                System.out.println("what do you want to do?");
                choice = scanner.nextLine();
                if (choice.equals("take " + ItemsList.pieceOfMap.getName())) {
                    action.takeItem(ItemsList.pieceOfMap);
                    coconutsInBackPack = true;
                    isPalmSectionCompleted = true;
                    System.out.println("You added " + ItemsList.pieceOfMap.getName() + " to your backpack");

                } else {
                    System.out.println("you left that a piece of map ");
                    coconutsInBackPack = false;

                }
            }

            }

//      ## BRICKS SECTION

        if (choice.equals("check bricks")) {
            System.out.println("You see a few red bricks, nothing special");
            System.out.println("what do you want to do?");
            choice = scanner.nextLine();

            if(choice.equals("touch")) {
                System.out.println("You touched bricks but nothing happened");
            }
            if(choice.equals("use "+ ItemsList.hammer.getName())) {
                if(isBricksSectionCompleted) {
                    System.out.println("you have nothing to do here anymore ");
                } else {
                    System.out.println("You smashed bricks and see some 'piece of paper' with some code!");
                    System.out.println("what do you want to do?");
                    choice = scanner.nextLine();
                    if (choice.equals("take " + ItemsList.pieceOfPaper.getName())) {
                        action.takeItem(ItemsList.pieceOfPaper);
                        isBricksSectionCompleted = true;
                        System.out.println("You added " + ItemsList.pieceOfPaper.getName() + " to your backpack");
                    } else {
                        System.out.println("you left that piece of paper ");
                    }
                }
            }

//      PLANTS SECTION

        if(choice.equals("check plants")) {
            checkPlants++;
            if(touched > 1 && checkPlants > 1 && !hammerInBackPack) {
                System.out.println("You see plants and hammer between leaves");
                System.out.println("what do you want to do ?");
                choice = scanner.nextLine();
                if (choice.equals("take " + ItemsList.hammer.getName())) {
                    action.takeItem(ItemsList.hammer);
                    hammerInBackPack = true;
                    isPlantsSectionCompleted = true;
                    System.out.println("You added " + ItemsList.hammer.getName() + " to your backpack");

                } else {
                    System.out.println("you left that hammer ");
                    hammerInBackPack = false;
                }

            } else {
                System.out.println("You see some plants");
                System.out.println("what do you want to do?");
                choice = scanner.nextLine();
            }
            if(choice.equals("touch")) {
                touched++;
                if(isPlantsSectionCompleted) {
                    System.out.println("You have taken already hammer and see only some plants");
                } else {
                    System.out.println("You touched plants and you see something between leaves");
                    try {
                        Thread.sleep(2000);
                        System.out.println("Its a hammer!");
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    System.out.println("what do you want to do because of that?");
                    choice = scanner.nextLine();
                    if (choice.equals("take " + ItemsList.hammer.getName())) {
                        action.takeItem(ItemsList.hammer);
                        hammerInBackPack = true;
                        isPlantsSectionCompleted = true;
                        System.out.println("You added " + ItemsList.hammer.getName() + " to your backpack");
                    } else {
                        System.out.println("you left that hammer ");
                        hammerInBackPack = false;

                    }
                }
            }

        }
        if(choice.equals("check chest")) {
            System.out.println("you see a chest, this chest has a lock with a code");
            System.out.println("what do you want to do?");
            choice = scanner.nextLine();
            if(choice.equals("touch")) {
                System.out.println("You touched a chest but it wont open");
            }
            if(choice.equals("use "+ItemsList.pieceOfPaper.getName())) {
                System.out.println("You opened a chest and found key to door! Now hurry, escape from room!");
            }
        }
        }
    }
}
    public static void main(String[] args) {
        System.out.println("Welcome in escape room");
        TextGame textGame = new TextGame();
        textGame.startGame();

//        textGame.action.takeItem(ItemsList.ThorHammer);
//        textGame.action.describeItem("hammer");
//        textGame.action.describeItem("fire sword");
//        textGame.action.showBackpack();
//        textGame.action.describeRoom();

    }
}
