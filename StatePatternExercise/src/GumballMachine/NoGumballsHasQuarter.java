package GumballMachine;

public class NoGumballsHasQuarter extends GumballMachineState {

    public NoGumballsHasQuarter(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    @Override
    public void addGumballs(int count) {
        gumballMachine.setState(new HasGumballsHasQuarter(gumballMachine));
    }

    // inserts a quarter into the slot
    @Override
    public void insertQuarter() {
        System.out.println("Slot already has quarter");
    }

    // removes the quarter currently in the slot (user changed their mind)
    @Override
    public void removeQuarter() {
        gumballMachine.setState(new NoGumballsHasQuarter(gumballMachine));
    }

    // consumes quarter and *doesn't* dispense gumballs
    @Override
    public void turnHandle() {
        gumballMachine.setNumQuarters(gumballMachine.getNumQuarters() + 1);
        System.out.println("Swallowed your quarter! Oops:) ");
        gumballMachine.setState(new NoGumballsNoQuarter(gumballMachine));
    }

}
