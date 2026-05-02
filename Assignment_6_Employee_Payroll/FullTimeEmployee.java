package Assignment_6_Employee_Payroll;

public class FullTimeEmployee extends Employee {

    protected double base_Salary;
    protected double extra_Benefit; // perfBonus or hiringCommission

    public FullTimeEmployee(String name, String panNo, String joiningDate, String designation, int empId, double baseSalary, double extraBenefit) {

        super(name, panNo, joiningDate, designation, empId);

        this.base_Salary = baseSalary;
        this.extra_Benefit = extraBenefit;
    }

    public double calcCTC() {
        // General logic for SWE or HR
        return base_Salary + extra_Benefit;
    }
}
