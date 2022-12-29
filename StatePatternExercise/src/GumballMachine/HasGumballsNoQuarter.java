package GumballMachine;

public class HasGumballsNoQuarter extends GumballMachineState {

    public HasGumballsNoQuarter(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    // inserts a quarter into the slot
    @Override
    public void insertQuarter() {
        gumballMachine.setState(new HasGumballsHasQuarter(gumballMachine));
    }

    // removes the quarter currently in the slot (user changed their mind)
    @Override
    public void removeQuarter() {
        System.out.println("You can't remove a quarter if you didn't put one in!");
    }

    // consumes quarter and dispenses gumballs
    @Override
    public void turnHandle() {
        System.out.println("Please pay to play");
    }

}
