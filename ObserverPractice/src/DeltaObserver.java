public class DeltaObserver implements Observer {

    private Flight oldFlight;

    DeltaObserver(Flight flight) {
        oldFlight = flight;
    }

    @Override
    public void updateObserver(Flight currFlight) {

        if (currFlight != null && oldFlight != null) {
            //Write a second observer class that displays the deltas (or changes) in
            // longitude, latitude, velocity, and altitude between status updates.
            String deltaOutput =
                    String.format("Change in lat: %f, Change in lon: %f, Change in vel: %f, Change in alt: %f",
                            (currFlight.latitude - oldFlight.latitude),
                            (currFlight.longitude - oldFlight.longitude),
                            (currFlight.velocity - oldFlight.velocity),
                            (currFlight.geo_altitude - currFlight.geo_altitude)
                    );
            System.out.println(deltaOutput);
        }

        oldFlight = currFlight;

    }

}
