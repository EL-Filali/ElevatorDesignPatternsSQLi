package ma.tp1.model.elevatorStates;

import ma.tp1.model.Elevator;
import ma.tp1.model.ElevatorState;

public class StopedState extends ElevatorState {
    @Override
    public Integer getDistanceFromTop(Integer nbrOfFloors, Elevator elevator) {
        return nbrOfFloors+1;
    }

    @Override
    public Integer getDistanceFromPosition(int position, Integer nbrOfFloors, Elevator elevator) {
        return nbrOfFloors+1;
    }

    @Override
    public void moveDown(Elevator elevator, int nbrOfFloor) {
        elevator.setState(new DownState());
    }

    @Override
    public void moveUp(Elevator elevator) {
        elevator.setState(new UpState());
    }
}
