package Module;
import java.util.Vector;

public class Pedicurist extends Employee{
    private String FootCareSpecialisation;
//    private static Vector<Pedicurist> pedicurists = new Vector<Pedicurist>();

    public Pedicurist(String name,Integer experience,String speciality, String FootCareSpecialisation,Integer id){
        super(name,experience,speciality,id);
        this.FootCareSpecialisation = FootCareSpecialisation;
//        if (pedicurists.size() == 0) {
//            this.id=1;
//        }
//        else {
//            this.id=pedicurists.lastElement().id+1;
//        }
//        pedicurists.add(this);
//    }
//    public int getSize() {
//        return pedicurists.size();
    }
    public Pedicurist(){}
}
