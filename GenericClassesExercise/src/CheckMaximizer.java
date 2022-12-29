public class CheckMaximizer {

    public static void main(String[] args) {
        Maximizer<String> strMaximizer = new Maximizer<>();
        strMaximizer.updateValue("a");
        strMaximizer.updateValue("z");
        strMaximizer.updateValue("m");
        String maxStr = strMaximizer.getValue();
        System.out.println(maxStr);

        Maximizer<Integer> intMaximizer = new Maximizer<>();
        intMaximizer.updateValue(-22);
        intMaximizer.updateValue(10000);
        intMaximizer.updateValue(33);
        Integer maxInt = intMaximizer.getValue();
        System.out.println(maxInt);
    }

}
