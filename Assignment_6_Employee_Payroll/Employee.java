package Assignment_6_Employee_Payroll;

// Root class
public abstract class Employee{

    // Abstract method to be implemented by child classes
    public abstract double calcCTC();

    protected String name;
    protected String panNo;
    protected String joiningDate;
    protected String designation;
    protected int empId;

    public Employee(String name, String panNo, String joiningDate, String designation, int empId){
        this.name = name;
        this.panNo = panNo;
        this.joiningDate = joiningDate;
        this.designation = designation;
        this.empId = empId;
    }

    public void displayDetails(){
        System.out.println(" ID: " + empId + "\n Name: " + name + "\n Role: " + designation);
    }
}
