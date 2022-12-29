package GumballMachine;

public class Main {

    public static void main(String[] args) {

        GumballMachine machine = new GumballMachine();

        //State should be GumballMachine.NoGumballsNoQuarter
        machine.setNumGumballs(0);
        machine.setNumQuarters(0);
        System.out.println("Current state: " + machine.getState()); //expected: GumballMachine.NoGumballsNoQuarter

        machine.insertQuarter();
        System.out.println("Current state: " + machine.getState()); //expected: GumballMachine.NoGumballsHasQuarter

        machine.turnHandle();
        System.out.println("Current state: " + machine.getState()); //expected: GumballMachine.NoGumballsNoQuarter
        System.out.println("Current profit: " + machine.getNumQuarters() + " quarters");

        machine.addGumballs(10);
        System.out.println("Current state: " + machine.getState()); //expected: GumballMachine.HasGumballsNoQuarter
    }

}
