package binarySearch;

import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {
    public static void main(String[] args) {
        {

            String[] array = new String[]{"arr", "bff", "ccc"};
            Integer searchPos = BinarySearch.search(array, "ccc");
            System.out.println("SEARCH_POS " + searchPos);


            //Binary Search as static method in Arrays
            int index = Arrays.binarySearch(array, "ccc");
//            int index2 = Collections.binarySearch(array, "ccc");
            System.out.println("INDEX = " + index);
        }
    }

    public static Integer search(Comparable[] array, Comparable itemSearch) {
        int indexMin = 0;
        int indexMax = array.length - 1;

        while (indexMin <= indexMax) {
            int indexMid = (indexMin + indexMax) / 2;

            Comparable itemMid = array[indexMid];
            Integer resultCompare = itemMid.compareTo(itemSearch);

            if (resultCompare == 0) {
                return indexMid;
            } else if (resultCompare > 0) {
                indexMax = indexMid - 1;
            } else {
                indexMin = indexMid + 1;
            }
        }
        return null;
    }
}
