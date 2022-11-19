package checkers.referee;

public class Referee {

    public Referee() {
    }

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
                if(j == strings.length-1) {
                    System.out.println("koniec");
                }
            }
            countBoardrow++;
        }
    }
}
