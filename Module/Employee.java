package Module;
import Module.HasId;

public abstract class Employee implements HasId {
protected Integer id;
    protected String name;
protected Integer experience;
protected String speciality;
protected Employee(String name, Integer experience, String speciality,Integer id) {
    this.name = name;
    this.experience = experience;
    this.speciality = speciality;
    this.id = id;
}
public Integer getId() {
    return id;
}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
