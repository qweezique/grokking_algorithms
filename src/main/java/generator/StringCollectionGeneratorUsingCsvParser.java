package generator;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringCollectionGeneratorUsingCsvParser {

    private static CSVReader csvReader;


    public static void main(String[] args) {
        String path = "src/main/resources/csv/person.csv";
        StringCollectionGeneratorUsingCsvParser.generateSortedDistinctFirstAndSecondNameArrayListFromFilePath(path)
                .forEach(System.out::println);
    }

    public static List<String> generateSortedDistinctFirstAndSecondNameArrayListFromFilePath(String pathToCsvFile) {
        List<String> FirstAndSecondNameList = new ArrayList<>();

        try {
            csvReader = new CSVReader(new BufferedReader(new FileReader(pathToCsvFile)));
            csvReader.skip(1);

            String[] strings;

            while ((strings = csvReader.readNext()) != null) {
                FirstAndSecondNameList.add((strings[0] + " " + strings[1]));
            }

            csvReader.close();

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return FirstAndSecondNameList
                .stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}


