package ma.tp1.model;

import lombok.Data;
import ma.tp1.model.elevatorFactory.ElevatorFactoryImp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Data
public class Building {
    private Integer nbrOfFloor;
    private List<Elevator> elevators;
    
    public Building(int nbrOfFloor,String ...elevatorsIds){
        this.nbrOfFloor=nbrOfFloor;
        elevators=new ArrayList<>();
        for (String idAndPos:elevatorsIds) {
            elevators.add(ElevatorFactoryImp.getInstance().createElevator(idAndPos));
            
        }

    }

    public void move(String idString,String upOrDown){
        Long id=Long.valueOf(idString.substring(2));
        switch (upOrDown) {
            case "DOWN":
                elevators.stream().filter(x -> (x.getId() == id)).forEach(x->x.moveDown(nbrOfFloor));
                break;
            case "UP":
                elevators.stream().filter(x -> (x.getId() == id)).forEach(Elevator::moveUp);
                break;
            default:
                break;
        }
    }

    public String requestElevator(){
         Optional<Elevator> optional= elevators.stream().min(Comparator.comparing(x->x.getDistanceFromTop(this.nbrOfFloor)));
         return "id"+optional.get().getId();
    }

    public String requestElevator(int position){
        Optional<Elevator> optional= elevators.stream().min(Comparator.comparing(x->x.getDistanceFromPosition(position,this.nbrOfFloor)));
        return "id"+optional.get().getId();
    }


    public void stopAt(String idString, int position) {
        Long id=Long.valueOf(idString.substring(2));
        elevators.stream().filter(x->x.getId()==id).forEach(x->x.stop(position));

    }
}
