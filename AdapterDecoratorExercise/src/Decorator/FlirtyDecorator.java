package Decorator;

import java.util.ArrayList;

public class FlirtyDecorator implements StringSource {

    private StringSource delegator;

    public FlirtyDecorator(StringSource delegator) {
        this.delegator = delegator;
    }

    @Override
    public String next() {
        String newString = "";
        String[] delegatorStringList = delegator.next().split(" ");
        for (String word : delegatorStringList) {
            newString += (word + ":) ");
        }
        return newString;
    }
}
