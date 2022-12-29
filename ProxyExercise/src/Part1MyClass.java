public class Part1MyClass implements Part1MyInterface {

    @Override
    public void talkToMe() {
        System.out.println( "Hey, let's chat!");
    }

    @Override
    public void eatLunch(String lunchOrder) {
        System.out.println("Yum yum yum " + lunchOrder);
    }

    @Override
    public void petADog(String dogName) {
        System.out.println("Ayy, mi " + dogName);
    }

}
