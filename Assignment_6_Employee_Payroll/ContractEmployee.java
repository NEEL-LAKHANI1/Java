package Assignment_6_Employee_Payroll;

public class ContractEmployee extends Employee {

    private int noOfHrs;
    private double hourly_Rate;

    public ContractEmployee(String name, String panNo, String joiningDate, String designation, int empId, int noOfHrs, double hourlyRate) {

        super(name, panNo, joiningDate, designation, empId);

        this.noOfHrs = noOfHrs;
        this.hourly_Rate = hourlyRate;
    }


    public double calcCTC() {
        return noOfHrs * hourly_Rate;
    }
}
