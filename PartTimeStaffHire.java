 

import javax.swing.JOptionPane;

public class PartTimeStaffHire extends StaffHire {

    private int workingHour;
    private int wagesPerHour;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private String shifts;
    private boolean joined;
    private boolean terminated;

    // Constructor for class PartTimeStaffHire
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, int workingHour, int wagesPerHour, String shifts) {
        super(vacancyNumber, designation, jobType); // call the constructor from the super class StaffHire. 
        this.wagesPerHour = wagesPerHour; // extract wages per hour from the parameter and set the variable to it.
        this.workingHour = workingHour; // extract working hour from the parameter and set the variable to it.
        this.shifts = shifts; // extract shift from the paramater and set the variable to it.
        this.staffName = ""; // set staff name to empty string
        this.joiningDate = ""; // set joining date to empty string
        this.qualification = ""; // set qualification to empty string
        this.appointedBy = ""; // set appointed to empty string
        this.joined = false; // set joined to false
        this.terminated = false; // Set terminate to false
    }

    // Getters for the class. 

    public int getWorkingHour() {
        return this.workingHour;
    }
    public void setWorkingHour(int wh){
        this.workingHour = wh;
    }

    public int getWagesPerHour() {
        return this.wagesPerHour;
    }
    public void setWagesPerHour(int wph){
        this.wagesPerHour = wph;
    }

    public String getStaffName() {
        return this.staffName;
    }
    public void setStaffName(String name){
        this.staffName = name;
    }

    public String getJoiningDate() {
        return this.joiningDate;
    }
    public void setJoiningDate(String jd){
        this.joiningDate = jd;
    }

    public String getQualification() {
        return this.qualification;
    }
    public void setQualification(String qn){
        this.qualification = qn;
    }

    public String getAppointedBy() {
        return this.appointedBy;
    }
    public void setAppointedBY(String ap){
        this.appointedBy = ap;
    }
    
    public String getShifts() {
        return this.shifts;
    }
    public void setShifts(String sft){
        this.shifts = sft;
    }

    public boolean getJoined() {
        return this.joined;
    }
    public void setJoined(boolean j){
        this.joined = j;
    }

    public boolean getTerminated() {
        return this.terminated;
    }
    

    

    // method to hire the part time staff
    public void hirePartTimeStaff(String staffName, String joiningDate, String qualification, String appointedBy) {
        if (!getJoined()) { // checking if the part time staff is joined or not.
            this.staffName = staffName;
            this.joiningDate = joiningDate;
            this.qualification = qualification;
            this.appointedBy = appointedBy;
            this.joined = true;
            JOptionPane.showMessageDialog(null, "Staff Appointed!");
            System.out.println(getStaffName() + " has been hired on " + getJoiningDate() + " by " + getAppointedBy());
        } else { // Error message to show if the part time staff is already hired.
            System.out.println("ERROR: Part Time Staff is already hired!");
            JOptionPane.showMessageDialog(null, "This Vacancy is already Appointed");
        }
    }

    // method to terminate the staff! 
    public void terminateStaff() { 
            this.staffName = "";
            this.joiningDate = "";
            this.qualification = "";
            this.appointedBy = "";
            this.joined = false;
            this.terminated = true;
    }

    // method to display the details of the part time staff
    @Override
    public void display() {
        super.display();
        System.out.println("Staff name : " + getStaffName());
        System.out.println("The working hour is : " + getWorkingHour());
        System.out.println("Hourly Rate is : " + getWagesPerHour());
        System.out.println("The staff was appointed by : " + getAppointedBy());
        System.out.println("Joined Date : " + getJoiningDate());
        System.out.println("Shift : " + getShifts());
        System.out.println("Qualification : " + getQualification());
    }
}
