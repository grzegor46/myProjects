package checkers.referee;

public class Referee {

    public Referee() {
    }

    public static void printboard(String[][] tablicaPionkow) {

        System.out.println("______________________________");
        System.out.println("");

        int count = 0;
        for (int i = 0; i < tablicaPionkow.length; i++) {
            for (int j = 0; j < tablicaPionkow[i].length; j++) {
                count++;
                System.out.print((tablicaPionkow[i][j]));
                if (count == 8) {
                    System.out.println("");
                    count = 0;
                }
            }
        }
    }
}
