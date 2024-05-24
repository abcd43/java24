import java.util.Scanner;

public class Calculator6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Display menu
        System.out.println("Calculator Menu:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Factorial");
        System.out.println("Enter your choice (1-5): ");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                addition();
                break;
            case 2:
                subtraction();
                break;
            case 3:
                multiplication();
                break;
            case 4:
                division();
                break;
            case 5:
                factorial();
                break;
            default:
                System.out.println("Invalid choice");
        }
        
        scanner.close();
    }
    
    public static void addition() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers to add:");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        double result = num1 + num2;
        System.out.println("Result: " + result);
        scanner.close();
    }
    
    public static void subtraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers to subtract:");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        double result = num1 - num2;
        System.out.println("Result: " + result);
        scanner.close();
    }
    
    public static void multiplication() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers to multiply:");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        double result = num1 * num2;
        System.out.println("Result: " + result);
        scanner.close();
    }
    
    public static void division() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dividend:");
        double dividend = scanner.nextDouble();
        System.out.println("Enter divisor:");
        double divisor = scanner.nextDouble();
        if (divisor == 0) {
            System.out.println("Cannot divide by zero");
        } else {
            double result = dividend / divisor;
            System.out.println("Result: " + result);
        }
        scanner.close();
    }
    
    public static void factorial() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to find factorial:");
        int num = scanner.nextInt();
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + num + " is: " + factorial);
        scanner.close();
    }
}
