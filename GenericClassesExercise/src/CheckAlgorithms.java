public class CheckAlgorithms {

    public static void main(String[] args) {
        String[] strArr = new String[] { "z", "a", "m" };
        Stats<String> strStats = Algorithms.calcStats(strArr);
        System.out.println(String.format("min: %s, max: %s",
                strStats.min, strStats.max));

        Integer[] intArr = new Integer[] { 10000, 33, -22 };
        Stats<Integer> intStats = Algorithms.calcStats(intArr);
        System.out.println(String.format("min: %d, max: %d", intStats.min, intStats.max));
    }

}
