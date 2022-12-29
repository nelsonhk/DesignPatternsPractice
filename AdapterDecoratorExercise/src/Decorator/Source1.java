package Decorator;

public class Source1 implements StringSource {

    @Override
    public String next() {
        return "I love you";
    }
}
