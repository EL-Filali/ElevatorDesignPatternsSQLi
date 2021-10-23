package ma.tp1.model.elevatorStates;

import ma.tp1.model.Elevator;
import ma.tp1.model.ElevatorState;

public class UpState extends ElevatorState {
    public UpState() {
        super.stateName="UP";
    }

    @Override
    public Integer getDistanceFromTop(Integer nbrOfFloors, Elevator elevator) {
        return nbrOfFloors-elevator.getPosition();
    }

    @Override
    public Integer getDistanceFromPosition(int position, Integer nbrOfFloors, Elevator elevator) {
        if(elevator.getPosition()>=position)
            return elevator.getPosition()+position;
        else
            return elevator.getPosition()-position;
    }

    @Override
    public void moveDown(Elevator elevator, int nbrOfFloor) {
        if(nbrOfFloor==elevator.getPosition())
            elevator.setState(new DownState());
    }

    @Override
    public void moveUp( Elevator elevator) {

    }


}
