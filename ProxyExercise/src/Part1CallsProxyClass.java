public class Part1CallsProxyClass {

    public static void main(String[] args) {
        System.out.println("Beginning a main function");

        Part1ProxyMyClass proxyMyClass = new Part1ProxyMyClass();

        proxyMyClass.talkToMe();
        proxyMyClass.eatLunch("Tuna fish sandwich");
        proxyMyClass.petADog("Toby");
    }

}
