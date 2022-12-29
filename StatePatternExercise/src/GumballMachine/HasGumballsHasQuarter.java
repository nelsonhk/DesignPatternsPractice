package GumballMachine;

public class HasGumballsHasQuarter extends GumballMachineState {

    public HasGumballsHasQuarter(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    // inserts a quarter into the slot
    @Override
    public void insertQuarter() {
        System.out.println("Slot already has quarter");
    }

    // removes the quarter currently in the slot (user changed their mind)
    @Override
    public void removeQuarter() {
        gumballMachine.setState(new HasGumballsNoQuarter(gumballMachine));
    }

    // consumes quarter and dispenses gumballs
    @Override
    public void turnHandle() {
        gumballMachine.setNumGumballs(gumballMachine.getNumGumballs() - 1);
        gumballMachine.setNumQuarters(gumballMachine.getNumQuarters() + 1);
        gumballMachine.setState(new HasGumballsNoQuarter(gumballMachine));
    }

}
