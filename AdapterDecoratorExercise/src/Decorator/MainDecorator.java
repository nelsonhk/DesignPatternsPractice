package Decorator;

public class MainDecorator {

    public static void main(String[] args) {
        System.out.println(new Source1().next());
        System.out.println(new Source2().next());

        System.out.println(new FlirtyDecorator(new Source1()).next());
        System.out.println(new ExcitedDecorator(new Source2()).next());

        System.out.println(new SpaciousDecorator(new FlirtyDecorator(new Source1())).next());

    }

}
