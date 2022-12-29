import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observerList = new ArrayList<>();

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    public void notifyObserver(Flight currFlight) {
        for (Observer observer : observerList) {
            observer.updateObserver(currFlight);
        }
    }

}
