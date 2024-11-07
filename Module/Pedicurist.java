package Module;
import java.util.Vector;

public class Pedicurist extends Employee{
    private String FootCareSpecialisation;
    private static Vector<Pedicurist> pedicurists = new Vector<Pedicurist>();

    public Pedicurist(String name,int experience,String speciality, String FootCareSpecialisation){
        super(name,experience,speciality);
        this.FootCareSpecialisation = FootCareSpecialisation;
        if (pedicurists.size() == 0) {
            this.id=1;
        }
        else {
            this.id=pedicurists.lastElement().id+1;
        }
        pedicurists.add(this);
    }
    public int getSize() {
        return pedicurists.size();
    }
}