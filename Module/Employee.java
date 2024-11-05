package Module;
import Module.HasId;

public abstract class Employee implements HasId {
protected Integer id;
protected String name;
protected Integer experience;
protected String speciality;
protected Employee(String name, Integer experience, String speciality) {
    this.name = name;
    this.experience = experience;
    this.speciality = speciality;
}
public Integer getId() {
    return id;
}

}
