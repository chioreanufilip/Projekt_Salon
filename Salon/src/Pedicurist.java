public class Pedicurist extends Employee{
    private String FootCareSpecialisation;
    public Pedicurist(String name,int experience,String speciality, String FootCareSpecialisation){
        super(name,experience,speciality);
        this.FootCareSpecialisation = FootCareSpecialisation;
    }
}
