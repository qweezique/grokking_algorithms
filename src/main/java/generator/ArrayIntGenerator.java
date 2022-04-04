package generator;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.stream.IntStream;

public class ArrayIntGenerator {

    private static int[] array;

    public static int[] generate(int arraySize) {
        Random random = new Random();
        array = new int[arraySize];
        IntStream.range(0, arraySize).forEach(i -> array[i] = random.nextInt(10_000));
        return array;
    }

    public static void printArrayStatistic(int[] array) {
        IntSummaryStatistics intSummaryStatistics = Arrays.stream(array).summaryStatistics();
        System.out.printf("%nGenerated array summary:%n" +
                "-size = %d%n" +
                "-min value = %d%n" +
                "-max value = %d%n", intSummaryStatistics.getCount(), intSummaryStatistics.getMin(), intSummaryStatistics.getMax(), intSummaryStatistics.getAverage(), intSummaryStatistics.getSum());
    }
}
