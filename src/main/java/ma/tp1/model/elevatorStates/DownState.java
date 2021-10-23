package ma.tp1.model.elevatorStates;

import ma.tp1.model.Elevator;
import ma.tp1.model.ElevatorState;

public class DownState extends ElevatorState {

    public DownState() {
        super.stateName = "DOWN";
    }

    @Override
    public Integer getDistanceFromTop(Integer nbrOfFloors, Elevator elevator) {
        return nbrOfFloors + elevator.getPosition();
    }

    @Override
    public Integer getDistanceFromPosition(int position, Integer nbrOfFloors, Elevator elevator) {
        if (elevator.getPosition() >= position)
            return elevator.getPosition() - position;
        else
            return elevator.getPosition() + position;
    }

    @Override
    public void moveDown(Elevator elevator, int nbrOfFloor) {

    }

    @Override
    public void moveUp(Elevator elevator) {
        if(elevator.getPosition()==0)
            elevator.setState(new UpState());
    }
}

