package generator;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.stream.IntStream;

public class ArrayIntGenerator {

    public static int[] generate(int arraySize) {
        Random random = new Random();

        return IntStream
                .generate(() -> random.nextInt(10_000))
                .limit(arraySize)
                .sorted()
                .toArray();
    }

    public static void printArrayStatistic(int[] array) {
        IntSummaryStatistics intSummaryStatistics = Arrays.stream(array).summaryStatistics();
        System.out.printf("%nGenerated array summary:%n" +
                "-size = %d%n" +
                "-min value = %d%n" +
                "-max value = %d%n", intSummaryStatistics.getCount(), intSummaryStatistics.getMin(), intSummaryStatistics.getMax());
    }
}
