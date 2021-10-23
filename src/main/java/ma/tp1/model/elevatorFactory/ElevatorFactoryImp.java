package ma.tp1.model.elevatorFactory;

import ma.tp1.model.Elevator;
import ma.tp1.model.elevatorStates.RestingState;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ElevatorFactoryImp implements ElevatorFactoryInterface {

    public static ElevatorFactoryImp instance;
    
    public static ElevatorFactoryImp getInstance(){
        if (instance == null)
        {   instance = new ElevatorFactoryImp();
        }
        return instance;
    }
    @Override
    public Elevator createElevator(String idAndPos) {
        Elevator elevator=new Elevator();
        Pattern p = Pattern.compile("[^:]+") ;
        Matcher m = p.matcher(idAndPos) ;
        m.find();
        Long id=Long.valueOf(m.group().substring(2));
        m.find();
        Integer pos=Integer.valueOf(m.group());
        elevator.setId(id);
        elevator.setPosition(pos);
        elevator.setState(new RestingState());
        return elevator;
    }
}
