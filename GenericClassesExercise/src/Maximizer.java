public class Maximizer <T extends Comparable> {

    private T maxValue;

    public void updateValue(T newValue) {
        if (maxValue == null || newValue.compareTo(maxValue) > 0) {
            maxValue = newValue;
        }
    }

    public T getValue() {
        return maxValue;
    }

}
