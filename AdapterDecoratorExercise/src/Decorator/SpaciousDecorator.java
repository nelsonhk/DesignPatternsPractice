package Decorator;

public class SpaciousDecorator implements StringSource {

    private StringSource delegator;

    public SpaciousDecorator(StringSource delegator) {
        this.delegator = delegator;
    }

    @Override
    public String next() {
        String newString = "";
        String[] delegatorStringList = delegator.next().split(" ");
        for (String word : delegatorStringList) {
            newString += (word + " \n");
        }
        return newString;
    }
}
