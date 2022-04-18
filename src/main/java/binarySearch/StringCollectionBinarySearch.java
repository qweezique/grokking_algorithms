package binarySearch;

import utils.generator.StringCollectionGeneratorUsingCsvParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.Constants.Paths.PERSON_CSV;

public class StringCollectionBinarySearch {


    public static void main(String[] args) {

        List<String> strings = StringCollectionGeneratorUsingCsvParser
                .generateSortedDistinctFirstAndSecondNameArrayListFromFilePath(PERSON_CSV);

        long startWorkingLinearSearching = System.currentTimeMillis();
        int indexLinearSearch = strings.indexOf("Adey Potkin"); //Линейный поиск средствами java.util.List
        System.out.printf("%nЗатраченное время при линейном поиске = %s, мс%n" +
                "Элемент найден под индексом %s", System.currentTimeMillis() - startWorkingLinearSearching, indexLinearSearch);

        long startWorkingBinarySearchingUtil = System.currentTimeMillis();
        int indexBinarySearchUtil = Collections.binarySearch(strings, "Adey Potkin"); //Бинарный поиск средствами java.util.Collections
        System.out.printf("%nЗатраченное время при линейном поиске = %s, мс%n" +

                "Элемент найден под индексом %s", System.currentTimeMillis() - startWorkingBinarySearchingUtil, indexBinarySearchUtil);
    }


    public static void binaryStringSearch(List<String> strings, String key) {
        ArrayList<Object> objects = new ArrayList<>();


    }
//
//    int indexedBinarySearch(List<? extends Comparable<? super T>> list, T key) {
//        int low = 0;
//        int high = list.size()-1;
//
//        while (low <= high) {
//            int mid = (low + high) >>> 1;
//            Comparable<? super T> midVal = list.get(mid);
//            int cmp = midVal.compareTo(key);
//
//            if (cmp < 0)
//                low = mid + 1;
//            else if (cmp > 0)
//                high = mid - 1;
//            else
//                return mid; // key found
//        }
//        return -(low + 1);  // key not found
//    }
}
