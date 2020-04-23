 

import javax.swing.JOptionPane;

public class FullTimeStaffHire extends StaffHire {

    // Defining variables for the class
    private int salary;
    private int workingHour;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;

    // Constructor for the class FullTimeStaffHire
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, int salary, int workingHour) {
        super(vacancyNumber, designation, jobType); // calling constructor from super class StaffHire
        this.salary = salary; // extracting salary from the parameter and assigning the variable to it.
        this.workingHour = workingHour; // extracting working hour from the parameter and assigning the variable to it.
        this.appointedBy = ""; // setting appointed by to empty string
        this.staffName = ""; // setting staff name to empty string
        this.joiningDate = ""; // setting joining date to empty string
        this.qualification = ""; // setting qualification to empty string
        this.joined = false; // setting joined to false
    }

    // setting up getters for the variables declared above
    public int getSalary() {
        return salary;
    }
    public void setSalary(int s) {
        this.salary = s;
    }

    public int getWorkingHour() {
        return workingHour;
    }
    public void setWorkingHour(int w) {
        this.workingHour = w;
    }

    public String getStaffName() {
        return staffName;
    }
    public void setStaffName(String name){
        this.staffName = name;
    }

    public String getJoiningDate() {
        return joiningDate;
    }
    public void setJoiningDate(String j){
        this.joiningDate = j;
    }

    public String getQualification() {
        return qualification;
    }
    public void setQualification(String q){
        this.qualification = q;
    }

    public String getAppointedBy() {
        return appointedBy;
    }
    public void setAppointedBY(String app){
        this.appointedBy = app;
    }
    
    public boolean getJoined(){
        return this.joined;
    }
    public void setJoined(boolean j){
        this.joined = j;
    }

    // Method to hire a full time staff
    public void hireFullTimeStaff(String staffName, String joiningDate, String qualification, String appointedBy) {
        if (!joined) {
            this.staffName = staffName;
            this.joiningDate = joiningDate;
            this.qualification = qualification;
            this.appointedBy = appointedBy;
            this.joined = true;
            JOptionPane.showMessageDialog(null, "Staff Appointed.");

        } else {
            JOptionPane.showMessageDialog(null, "This Vacancy is already Appointed");
        }
    }

    //Method to desplay all the details of the full time staff.
    @Override
    public void display() {
        super.display();
        System.out.println("Staff name : " + getStaffName());
        System.out.println("The salary is : " + getSalary());
        System.out.println("The working hour is : " + getWorkingHour());
        System.out.println("The staff was appointed by : " + getAppointedBy());
        System.out.println("Joined Date : " + getJoiningDate());
        System.out.println("Qualification : " + getQualification());
    }

}
// sugus 
