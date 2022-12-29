public class StatusObserver implements Observer{

    @Override
    public void updateObserver(Flight currFlight) {

        if (currFlight == null) {
            System.out.println("Status: Flight Over");
        } else {
            System.out.println(currFlight);
        }
    }

}
