package ma.tp1.model;

public abstract class  ElevatorState {
    protected String stateName;

    public abstract Integer getDistanceFromTop(Integer nbrOfFloors, Elevator elevator);
    public abstract Integer getDistanceFromPosition(int position, Integer nbrOfFloors, Elevator elevator);
    public abstract void moveDown(Elevator elevator ,int nbrOfFloor);
    public abstract void moveUp(Elevator elevator );

}
