import java.util.*;

public class Part1ProxyMyClass implements Part1MyInterface {

    List<String> allowedDays = new ArrayList<>();
    Map<Integer, String> daysOfTheWeek = new HashMap<>();
    Integer[] allowedTimeRange = new Integer[2];

    Part1MyClass myClass = new Part1MyClass();

    public Part1ProxyMyClass() {
        allowedDays.add("T");
        allowedDays.add("W");
        allowedDays.add("Th");

        daysOfTheWeek.put(1, "Su");
        daysOfTheWeek.put(2, "M");
        daysOfTheWeek.put(3, "T");
        daysOfTheWeek.put(4, "W");
        daysOfTheWeek.put(5, "F");
        daysOfTheWeek.put(6, "S");
        daysOfTheWeek.put(7, "Su");

        allowedTimeRange[0] = 8;
        allowedTimeRange[1] = 22;
    }

    @Override
    public void talkToMe() {
        if (checkDateAndTime() == true) {
            myClass.talkToMe();
        } else {
            System.out.println("You can't talk to me right now");
        }
    }

    @Override
    public void eatLunch(String lunchOrder) {
        if (checkDateAndTime() == true) {
            myClass.eatLunch(lunchOrder);
        } else {
            System.out.println("It's not time to eat lunch yet!");
        }
    }

    @Override
    public void petADog(String dogName) {
        if (checkDateAndTime() == true) {
            myClass.petADog(dogName);
        } else {
            System.out.println("It's not time to pet " + dogName);
        }
    }

    private boolean checkDateAndTime() {
        Calendar calendar = new GregorianCalendar();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if (allowedDays.contains(daysOfTheWeek.get(dayOfWeek))) {
            if (allowedTimeRange[0] <= hourOfDay && allowedTimeRange[1] >= hourOfDay) {
                return true;
            }
        }
        return false;
    }
}
