package Decorator;

public class ExcitedDecorator implements StringSource {

    private StringSource delegator;

    public ExcitedDecorator(StringSource delegator) {
        this.delegator = delegator;
    }

    @Override
    public String next() {
        String newString = "";
        String[] delegatorStringList = delegator.next().split(" ");
        for (String word : delegatorStringList) {
            newString += (word + "!!! ");
        }
        return newString;
    }
}
