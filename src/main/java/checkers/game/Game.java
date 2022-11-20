package checkers.game;

public class Game {

    public void printboard(String[][] tablicaPionkow) {

        System.out.println("______________________________");
        System.out.println("");

        int count = 0;
        int countBoardrow = 0;
        for (String[] strings : tablicaPionkow) {
            System.out.print(countBoardrow+" ");
            for (int j = 0; j < strings.length; j++) {
                count++;
                System.out.print((strings[j]));


                if (count == 8) {
                    System.out.println("");

                    count = 0;
                }
                if(countBoardrow == 7 &&j == strings.length-1) {
                    for(int i = 0; i < 8 ; i++) {
                        System.out.print("  "+i+"");
                    }
                }
            }
            countBoardrow++;
        }
    }
}
