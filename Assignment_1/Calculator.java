package Assignment_1;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        ArithmeticOperations opr = new ArithmeticOperations();

        int ch, n1,n2;

        System.out.println("Calculator Program :-");
        do{
            System.out.println("1. Addition\n 2. Subtraction\n 3. Multiplication\n 4. Division\n 5. Modulus\n 6.Exit\n");
            System.out.println("Enter choice :- ");
            ch = s.nextInt();

            System.out.println("Enter first number :- ");
            opr.n1 = s.nextInt();

            System.out.println("Enter second number :- ");
            opr.n2 = s.nextInt();


            switch(ch){

                case 1:
                    System.out.println("Addition :- "+ opr.add(opr.n1, opr.n2));
                    break;

                case 2:
                    System.out.println("Subtraction :- "+ opr.subtract(opr.n1, opr.n2));
                    break;

                case 3:
                    System.out.println("Multiplication :- "+ opr.multiply(opr.n1, opr.n2));
                    break;
        
                case 4:
                    System.out.println("Division :- "+ opr.divide(opr.n1, opr.n2));
                    break;

                case 5:
                    System.out.println("Modulus :- "+ opr.modulus(opr.n1, opr.n2));  
                    break; 

                case 6:
                    System.out.println("Exiting !");
                    break;

                default: 
                    System.out.println("Invalid Choice !"); 
            } 
              
        } while(ch != 6);
    }
}
