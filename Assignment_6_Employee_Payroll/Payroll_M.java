package Assignment_6_Employee_Payroll;

public class Payroll_M {

    public static void main(String[] args){

        // 1. Hierarchical: FullTimeEmployee (SWE)
        FullTimeEmployee swe = new FullTimeEmployee("Aman", "ABC1234", "2023-01-10", "SWE", 101, 80000, 5000);

        // 2. Hierarchical: ContractEmployee
        ContractEmployee contractor = new ContractEmployee("Ash", "XYZ5678", "2023-05-15", "Consultant", 201, 160, 50);

        // 3. Multilevel: Manager (inherits from FullTimeEmployee)
        Manager manager = new Manager("Dev", "MGR9999", "2020-03-20", "Tech Lead", 301, 120000, 15000, 8000, 4000);

        System.out.println("Employee Payroll Report");

        swe.displayDetails();
        System.out.println("Total CTC: ( INR )" + swe.calcCTC());

        System.out.println("\n");

        contractor.displayDetails();
        System.out.println("Total CTC: ( INR )" + contractor.calcCTC());

        System.out.println("\n");

        manager.displayDetails();
        System.out.println("Total CTC: ( INR )" + manager.calcCTC());
    }
}
