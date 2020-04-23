 
public class StaffHire{
    private int vacancyNumber;
    private String designation;
    private String jobType;

    
    // constructor for the class StaffHire
    public StaffHire(int vacancyNumber, String designation, String jobType){
        this.vacancyNumber = vacancyNumber;
        this.designation = designation;
        this.jobType = jobType;
    }
    
    
    
    // getters and setters for the variables defined above
    public int getVacancyNumber(){
        return this.vacancyNumber;
    }
    public void setVacancyNumber(int v){
        this.vacancyNumber = v;
    }
    
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getJobType() {
        return jobType;
    }
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }



    

    // method to desplay all the details of the Staff
    public void display(){
        System.out.println("The Vacancy Number is : " + getVacancyNumber());
        System.out.println("The Designation is : " + getDesignation());
        System.out.println("The Job Type is : " + getJobType());
    }

}
