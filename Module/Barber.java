package Module;

import java.util.Vector;
//import java.util.List;

public class Barber extends Employee {
//    private static Vector<Barber> barbers = new Vector<>();
    private String hairStyle;
    public Barber(String name, String hairStyle, int experience, String speciality) {
        super(name,experience,speciality);
        this.hairStyle = hairStyle;
//        if (barbers.size() == 0) {
//            this.id=1;
//        }
//        else {
//            this.id=barbers.lastElement().id+1;
//        }
//        barbers.add(this);
    }
//    public int getSizeBarber(){
//        return barbers.size();
//    }
//    public void createBarber(String name, String hairStyle, int experience,String speciality){

//    }
}

