package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {

        public ArrayList<Integer> sortList(ArrayList<Integer> listToSort){
            boolean isSorted = false;
            int j = 0;
            while(!isSorted) {
                for (int i = 0; i < listToSort.size()-1; i++) {
                    if(listToSort.get(i) > listToSort.get(i+1)) {
                        int temp = listToSort.get(i);
                        listToSort.set(i,listToSort.get(i+1));
                        listToSort.set(i+1,temp);
                        j++;
                    }
                }
                if(j>0) {
                    j = 0;
                } else {
                    isSorted = true;
                }
            }
            return listToSort;

    }
    public static void main(String[] args) {

        BubbleSort bubbleSort = new BubbleSort();

//        ArrayList<Integer> listToSort = new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5, 4, 3,2,1));
        ArrayList<Integer> listToSort = new ArrayList<>(Arrays.asList(9, 7, 7, 6, 5, 1, 2,2,1));
        System.out.println("Array before: " + listToSort);
        System.out.println("Array after sort: " + bubbleSort.sortList(listToSort));

    }
}
