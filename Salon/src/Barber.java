public class Barber extends Employee {
    private String hairStyle;
    public Barber(String name, String hairStyle, int experience,String speciality) {
        super(name,experience,speciality);
        this.hairStyle = hairStyle;
    }
}
