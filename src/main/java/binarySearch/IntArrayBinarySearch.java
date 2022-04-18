package binarySearch;

import utils.generator.ArrayIntGenerator;
import linearSearch.IntArrayLinearSearcher;

import java.util.Arrays;


public class IntArrayBinarySearch {

    public static final int SEARCHING_ITEM = 9255;

    public static void main(String[] args) {
        {
            int[] generatedSortedArray = ArrayIntGenerator.generate(100_000_000); // Генерируем массив, передаем размерность в аргументы. Каждый элемент массива - это рандомное число от 0 до 10_000

            Arrays.stream(generatedSortedArray).forEach(System.out::println); // Убедимся, что массив отсортирован. Алгоритм бинарного поиска работает только для сортированных массивов/списков

            ArrayIntGenerator.printArrayStatistic(generatedSortedArray); // Выведем сводную информацию о массиве

            long startWorkingLinearSearching = System.currentTimeMillis();
            int indexLinearSearch = IntArrayLinearSearcher.getIndexOfSearchingItem(generatedSortedArray, SEARCHING_ITEM);
            System.out.printf("%nЗатраченное время при линейном поиске = %s, мс%n" +
                    "Элемент найден под индексом %s", System.currentTimeMillis() - startWorkingLinearSearching, indexLinearSearch);


            long startWorkingBinarySearching = System.currentTimeMillis();
            int indexBinarySearch = binarySearch(generatedSortedArray, SEARCHING_ITEM); // Бинарный поиск из java.utils
            System.out.printf("%nЗатраченное время при бинарном поиске = %s, мс%n" +
                    "Элемент найден под индексом %s", System.currentTimeMillis() - startWorkingBinarySearching, indexBinarySearch);

            long startWorkingBinaryRecursiveSearching = System.currentTimeMillis();
            int indexBinaryRecursiveSearch = binarySearchRecursive(generatedSortedArray, SEARCHING_ITEM, 0, generatedSortedArray.length - 1); // Бинарный поиск из java.utils
            System.out.printf("%nЗатраченное время при бинарном рекурсивном поиске = %s, мс%n" +
                    "Элемент найден под индексом %s", System.currentTimeMillis() - startWorkingBinaryRecursiveSearching, indexBinaryRecursiveSearch);
        }
    }

    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (key < array[middle]) {
                high = middle - 1;
            } else if (key > array[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


    public static int binarySearchRecursive(int[] sortedArray, int key, int low, int high) {
        // считаем индекс центрального элемента
        int middle = low + (high - low) / 2;

        // base case (условие выхода) - регион поиска пустой
        if (low > high) {
            // не нашли элемента, который равен ключу
            return -1;
        }

        if (key == sortedArray[middle]) {
            // в случае, если элемент в центре равняется ключу (нашли элемент)
            return middle;
        } else if (key < sortedArray[middle]) {
            // рекурсивный вызов для левого подмассива
            // не забывайте здесь ключевое слово return (подумайте, зачем оно нужно)
            return binarySearchRecursive(sortedArray, key, low, middle - 1);
        } else {
            // рекурсивный вызов для правого помассива
            return binarySearchRecursive(sortedArray, key, middle + 1, high);
        }
    }
    /*
      Ссылка на код, и сам код взят из видеоролика Наиля Алишева про Бинарный поиск
      https://gist.github.com/NeilAlishev/88abc5c7bfbf7eea9d942837cd993e82
     */
}
