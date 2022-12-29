import java.util.List;

public class Algorithms {

    public static <T extends Comparable> Stats<T> calcStats(T[] valueArray) {
        T min = getMin(valueArray);
        T max = getMax(valueArray);

        Stats<T> stats = new Stats<>();
        stats.min = min;
        stats.max = max;

        return stats;

    }

    private static <T extends Comparable> T getMin(T[] valueArray) {

        T minValue = null;

        for (int i = 0; i < valueArray.length; i++) {
            if (minValue == null || valueArray[i].compareTo(minValue) < 0) {
                minValue = valueArray[i];
            }
        }

        return minValue;
    }

    private static <T extends Comparable> T getMax(T[] valueArray) {

        T maxValue = null;

        for (int i = 0; i < valueArray.length; i++) {
            if (maxValue == null || valueArray[i].compareTo(maxValue) > 0) {
                maxValue = valueArray[i];
            }
        }

        return maxValue;
    }

}
