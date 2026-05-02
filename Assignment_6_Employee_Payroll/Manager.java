package Assignment_6_Employee_Payroll;

public class Manager extends FullTimeEmployee{

    private double travel_allowance;
    private double edu_allowance;

    public Manager(String name, String panNo, String joiningDate, String designation, int empId, double baseSalary, double perfBonus, double TA, double edu){

        super(name, panNo, joiningDate, designation, empId, baseSalary, perfBonus);

        this.travel_allowance = TA;
        this.edu_allowance = edu;
    }

    public double calcCTC(){

        // Reuses baseSalary + perfBonus from FullTimeEmployee and adds extras
        return super.calcCTC() + travel_allowance + edu_allowance;
    }
}
