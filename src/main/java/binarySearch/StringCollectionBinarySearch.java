package binarySearch;

import generator.StringCollectionGeneratorUsingCsvParser;

import java.util.Collections;
import java.util.List;

import static utils.Constants.Paths.PERSON_CSV;

public class StringCollectionBinarySearch {


    public static void main(String[] args) {

        List<String> strings = StringCollectionGeneratorUsingCsvParser.generateSortedDistinctFirstAndSecondNameArrayListFromFilePath(PERSON_CSV);

        long startWorkingLinearSearching = System.currentTimeMillis();
        int indexLinearSearch = strings.indexOf("Adey Potkin"); //Линейный поиск средствами java.util.List
        System.out.printf("%nЗатраченное время при линейном поиске = %s, мс%n" +
                "Элемент найден под индексом %s", System.currentTimeMillis() - startWorkingLinearSearching, indexLinearSearch);

        long startWorkingBinarySearchingUtil = System.currentTimeMillis();
        int indexBinarySearchUtil = Collections.binarySearch(strings,"Adey Potkin"); //Бинарный поиск средствами java.util.Collections
        System.out.printf("%nЗатраченное время при линейном поиске = %s, мс%n" +
                "Элемент найден под индексом %s", System.currentTimeMillis() - startWorkingBinarySearchingUtil, indexBinarySearchUtil);
    }
}
