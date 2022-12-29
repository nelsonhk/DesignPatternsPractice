
public class FlightMonitor {
	
	public static void main(String[] args) {
	
		FlightFeed feed = new FlightFeed();

		// Initialize subject/observer objects, attach to subject
		StatusObserver statusObserver = new StatusObserver();
		DeltaObserver deltaObserver = new DeltaObserver(null);

		feed.attach(statusObserver);
		feed.attach(deltaObserver);

		feed.start();
	}
	
}