package GumballMachine;

public class NoGumballsNoQuarter extends GumballMachineState {

    public NoGumballsNoQuarter(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    @Override
    public void addGumballs(int count) {
        gumballMachine.setState(new HasGumballsNoQuarter(gumballMachine));
    }

    // inserts a quarter into the slot
    @Override
    public void insertQuarter() {
        gumballMachine.setState(new NoGumballsHasQuarter(gumballMachine));
    }

    // removes the quarter currently in the slot (user changed their mind)
    @Override
    public void removeQuarter() {
        System.out.println("You can't remove a quarter if you didn't put one in!");
    }

    // consumes quarter and *doesn't* dispense gumballs
    @Override
    public void turnHandle() {
        System.out.println("Please pay to play");
    }

}
