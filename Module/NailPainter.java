package Module;
import java.util.Vector;
public class NailPainter extends Employee{
    private String gelNailExperience;
//    private static Vector<NailPainter> nails = new Vector<NailPainter>();
    public NailPainter(String name,int experience,String speciality,String gelNailExperience,Integer id) {
        super(name,experience,speciality, id);
        this.gelNailExperience = gelNailExperience;
//        if (nails.isEmpty()) {
//            this.id=1;
//        }
//        else {
//            this.id=nails.lastElement().id+1;
//        }
//        nails.add(this);
//    }
//    public int getSize(){
//        return nails.size();
    }
}
