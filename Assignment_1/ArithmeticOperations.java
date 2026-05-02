package Assignment_1;

public class ArithmeticOperations{

    public int n1, n2;

    // Method to add 2 numbers 
    public int add(int a, int b){
        return a+b;
    }

    // Method to subtract 2 numbers
    public int subtract(int a, int b){
        return a-b;
    }

    // Method to multiply 2 numbers 
    public int multiply(int a, int b){
        return a*b;
    }

    // Method to divide 2 numbers 
    public double divide(int a, int b){
        if (b==0){
            System.out.println("Zero Division Error ! ");
            return 0;
        }
        return (double) a/b;
    }

    // Method to find the remainder
    public int modulus(int a, int b){
        if (b==0){
            System.out.println("Modulus by zero not allowed ! ");
            return 0;
        }
        return a%b;
    }

/*
    public static void main(String[] args){

        // To access the data members and member methods of AO class, we need to create an object of it 
        // Create object - Class name followed by object name

        Scanner s= new Scanner(System.in);

        ArithmeticOperations opr = new ArithmeticOperations();       // creating object opr of the class

        System.out.println("Enter first number :- ");
        opr.n1 = s.nextInt();

        System.out.println("Enter second number :- ");
        opr.n2 = s.nextInt();

        System.out.println("Addition :- "+ opr.add(opr.n1, opr.n2));
        System.out.println("Subtraction :- "+ opr.subtract(opr.n1, opr.n2));
        System.out.println("Multiplication :- "+ opr.multiply(opr.n1, opr.n2));
        System.out.println("Division :- "+ opr.divide(opr.n1, opr.n2));
        System.out.println("Modulus :- "+ opr.modulus(opr.n1, opr.n2));
    }
*/    
}
