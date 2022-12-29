package GumballMachine;

public class GumballMachineState {

    public GumballMachine gumballMachine;

    public GumballMachineState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    // adds more gumballs to the machine
    public void addGumballs(int count) {
        gumballMachine.setNumGumballs(gumballMachine.getNumGumballs() + count);
    }

    // inserts a quarter into the slot
    public void insertQuarter() {}

    // removes the quarter currently in the slot (user changed their mind)
    public void removeQuarter() {}

    // consumes quarter and dispenses gumballs
    public void turnHandle() {}

}
