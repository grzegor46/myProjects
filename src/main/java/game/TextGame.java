package game;

import java.util.Scanner;

public class TextGame {

    Action action = new Action();
    Scanner scanner = new Scanner(System.in);


    public void startGame () {

    System.out.println(" \nIf you need help, you can just type 'help'");
        System.out.println("If you want quit, type 'quit' \n");

    while(!Properties.isGameOver) {
        System.out.println("What do you wanna check?");
        String choice = scanner.nextLine();

        if(choice.equals("quit")) {
            Properties.isGameOver = true;
            System.out.println("Goodbye...");
        }

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
            System.out.println("Which item do you want to check?");
            action.showBackpack();
            choice = scanner.nextLine();
            action.describeItem(choice);
        }

//      ## PALM SECTION

        if (choice.equals("check palm")) {
            Properties.checkPalm++;
            if(Properties.touched >= 2 && Properties.isCoconutsDroped && Properties.checkPalm >= 3) {
                if (Properties.isPalmSectionCompleted) {
                    System.out.println("You see only crashed coconuts, because you have already taken content");
                } else {
                    System.out.println("You came back to palm and see drawing");
                    System.out.println("what do you want to do?");
                    choice = scanner.nextLine();
                    if (choice.equals("take " + ItemsList.drawing.getName())) {
                        action.takeItem(ItemsList.drawing);
                        Properties.isPalmSectionCompleted = true;
                        System.out.println("You added " + ItemsList.drawing.getName() + " to your backpack");
                    } else {
                        System.out.println("you left that a drawing ");
                    }
                }
            } else {
                System.out.println("You see a palm, it has some coconuts");
                System.out.println("what do you want to do?");
                choice = scanner.nextLine();
            }

            if(choice.equals("touch")) {
                Properties.touched++;
                if(Properties.isPalmSectionCompleted) {
                    System.out.println("You touched a palm, but nothing happened");
                }

            }

            if(Properties.touched == 1) {
                System.out.println("You touched a palm, but nothing happened");
            }

            if (Properties.touched == 2 && !Properties.isCoconutsDroped) {
                System.out.println("You touched a palm. One of the coconuts fell and crashed in half and inside was a 'drawing'");
                Properties.isCoconutsDroped = true;
                System.out.println("what do you want to do?");
                choice = scanner.nextLine();
                if (choice.equals("take " + ItemsList.drawing.getName())) {
                    action.takeItem(ItemsList.drawing);
                    Properties.isPalmSectionCompleted = true;
                    System.out.println("You added " + ItemsList.drawing.getName() + " to your backpack");

                } else {
                    System.out.println("you left that drawing ");
                }
            }

            }

//      ## BRICKS SECTION

        if (choice.equals("check bricks")) {
            System.out.println("You see a few red bricks, nothing special");
            System.out.println("what do you want to do?");
            choice = scanner.nextLine();

            if (choice.equals("touch")) {
                System.out.println("You touched bricks but nothing happened");
            }
            if (choice.equals("use " + ItemsList.hammer.getName()) && Properties.isHammerInBackPack && Properties.isPalmSectionCompleted) {
                action.useItem(ItemsList.hammer);
                    if (Properties.isBricksSectionCompleted) {
                        System.out.println("you have nothing to do here anymore ");
                    } else {
                        System.out.println("You smashed bricks and see some 'piece of paper' with some code!");

                        System.out.println("what do you want to do?");
                        choice = scanner.nextLine();
                        if (choice.equals("take " + ItemsList.pieceOfPaper.getName())) {
                            action.takeItem(ItemsList.pieceOfPaper);
                            Properties.isPieceOfPaperInBackpack = true;
                            Properties.isBricksSectionCompleted = true;
                            System.out.println("You added " + ItemsList.pieceOfPaper.getName() + " to your backpack");
                        } else {
                            System.out.println("you left that piece of paper ");
                        }
                    }
            }
        }

//      PLANTS SECTION

        if(choice.equals("check plants")) {
            Properties.checkPlants++;
            if(Properties.touched > 1 && Properties.checkPlants > 1 && !Properties.isHammerInBackPack) {
                System.out.println("You see plants and hammer between leaves");
                System.out.println("what do you want to do ?");
                choice = scanner.nextLine();
                if (choice.equals("take " + ItemsList.hammer.getName())) {
                    action.takeItem(ItemsList.hammer);
                    Properties.isHammerInBackPack = true;
                    Properties.isPlantsSectionCompleted = true;
                    System.out.println("You added " + ItemsList.hammer.getName() + " to your backpack");

                } else {
                    System.out.println("you left that hammer ");
                }

            } else {
                System.out.println("You see some plants");
                System.out.println("what do you want to do?");
                choice = scanner.nextLine();
            }
            if(choice.equals("touch")) {
                Properties.touched++;
                if(Properties.isPlantsSectionCompleted) {
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
                        Properties.isHammerInBackPack = true;
                        Properties.isPlantsSectionCompleted = true;
                        System.out.println("You added " + ItemsList.hammer.getName() + " to your backpack");
                    } else {
                        System.out.println("you left that hammer ");
                    }
                }
            }
        }
        if(choice.equals("check chest")) {
            System.out.println("you see a chest, this chest has a lock");
            System.out.println("what do you want to do?");
            choice = scanner.nextLine();
            if(choice.equals("touch")) {
                System.out.println("You touched a chest but it wont open");
                System.out.println("you left a chest");
            }
            if(choice.equals("use "+ItemsList.pieceOfPaper.getName()) && Properties.isPieceOfPaperInBackpack) {
                action.useItem(ItemsList.pieceOfPaper);
                System.out.println("You opened a chest and found key to door! Now hurry, escape from the room!");
                System.out.println("You did it! Congratulations!");
                Properties.isGameOver = true;
            }
        }

        }
    }
}
