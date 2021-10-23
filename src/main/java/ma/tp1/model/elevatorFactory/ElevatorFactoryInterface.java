package ma.tp1.model.elevatorFactory;

import ma.tp1.model.Elevator;

public interface ElevatorFactoryInterface {
    public Elevator createElevator(String idAndPos);
}
