public class FinalExam {

    /**
     * Consider a car with the following gears: “park”, “drive” and “reverse”.
     * The car behaves differently depending on which gear it is currently in.
     * The car has the following operations (or inputs):
     * “putInPark”, “putInDrive”, “putInReverse”, “accelerate”, and “decelerate”.
     * Write Java code to demonstrate how you would use the State pattern
     * to implement the stateful behavior of the car.
     * (HINT: Put all car behavior in the state classes.)
     */


    public class Car {
        // put the car in an initial state (parked seems obvious)
        private CarState carState = new ParkState(this);

        public CarState getCarState() {
            return carState;
        }

        public void setCarState(CarState carState) {
            this.carState = carState;
        }
    }

    abstract public class CarState {

        public Car car;

        public CarState(Car car) {
            this.car = car;
        }

        abstract public void putInPark();
        abstract public void putInDrive();
        abstract public void putInReverse();
        abstract public void accelerate();
        abstract public void decelerate();
    }

    public class ParkState extends CarState {

        public ParkState(Car car) {
            super(car);
        }

        @Override
        public void putInPark() {
            System.out.println("You're already parked!");
        }

        @Override
        public void putInDrive() {
            System.out.println("Driving now");
            // update the state variable, we are no longer parked, are now driving, so the state must change
            car.setCarState(new DriveState(car));
        }

        @Override
        public void putInReverse() {
            System.out.println("Reversing now");
            car.setCarState(new ReverseState(car));
        }

        @Override
        public void accelerate() {
            System.out.println("You're causing a scene! Plus, accelerating while parked isn't good for the engine.");

        }

        @Override
        public void decelerate() {
            System.out.println("No need to press on the brakes while you're parked...but you do you :) ");
        }
    }

    public class DriveState extends CarState {

        public DriveState(Car car) {
            super(car);
        }

        @Override
        public void putInPark() {
            System.out.println("Parking now");
            car.setCarState(new ParkState(car));
        }

        @Override
        public void putInDrive() {
            System.out.println("You're already driving!");
        }

        @Override
        public void putInReverse() {
            System.out.println("Reversing now");
            car.setCarState(new ReverseState(car));
        }

        @Override
        public void accelerate() {
            // I don't think we would have a separate state for accelerating/decelerating. But we could
            // keep track of it using a member variable? It would just depend on the context and whether
            // it is important or not to keep track of.
            System.out.println("Going faster!");
        }

        @Override
        public void decelerate() {
            System.out.println("Going slower");
        }
    }

    // You get the picture - you would continue this for the Reverse State as well
    public class ReverseState extends CarState {

        public ReverseState(Car car) {
            super(car);
        }

        @Override
        public void putInPark() {

        }

        @Override
        public void putInDrive() {

        }

        @Override
        public void putInReverse() {

        }

        @Override
        public void accelerate() {

        }

        @Override
        public void decelerate() {

        }
    }

}
