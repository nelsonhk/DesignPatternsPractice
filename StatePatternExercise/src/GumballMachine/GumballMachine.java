package GumballMachine;

public class GumballMachine {

    private int numGumballs;
    private int numQuarters;

    private GumballMachineState state = new NoGumballsNoQuarter(this);

    // adds more gumballs to the machine
    public void addGumballs(int count) {
        state.addGumballs(count);
    }

    // inserts a quarter into the slot
    public void insertQuarter() {
        state.insertQuarter();
    }

    // removes the quarter currently in the slot (user changed their mind)
    public void removeQuarter() {
        state.removeQuarter();
    }

    // consumes quarter and dispenses gumballs
    public void turnHandle() {
        state.turnHandle();
    }

    public int getNumGumballs() {
        return numGumballs;
    }

    public void setNumGumballs(int numGumballs) {
        this.numGumballs = numGumballs;
    }

    public int getNumQuarters() {
        return numQuarters;
    }

    public void setNumQuarters(int numQuarters) {
        this.numQuarters = numQuarters;
    }

    public GumballMachineState getState() {
        return state;
    }

    public void setState(GumballMachineState state) {
        this.state = state;
    }

}
