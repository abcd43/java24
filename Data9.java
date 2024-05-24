import java.util.Scanner;

class User {
    private int age;
    private double income;
    private String city;
    private boolean hasFourWheeler;

    public User(int age, double income, String city, boolean hasFourWheeler) {
        this.age = age;
        this.income = income;
        this.city = city;
        this.hasFourWheeler = hasFourWheeler;
    }

    public void validate() throws InvalidUserException {
        if (age < 18 || age > 55) {
            throw new InvalidUserException("Age must be between 18 and 55");
        }
        if (income < 50000 || income > 100000) {
            throw new InvalidUserException("Income must be between Rs. 50,000 and Rs. 1,00,000 per month");
        }
        if (!(city.equals("Pune") || city.equals("Mumbai") || city.equals("Bangalore") || city.equals("Chennai"))) {
            throw new InvalidUserException("User must stay in Pune, Mumbai, Bangalore, or Chennai");
        }
        if (!hasFourWheeler) {
            throw new InvalidUserException("User must have a 4-wheeler");
        }
    }
}

class InvalidUserException extends Exception {
    public InvalidUserException(String message) {
        super(message);
    }
}

public class Data9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        User user = null;

        while (!isValid) {
            try {
                System.out.print("Enter age: ");
                int age = scanner.nextInt();

                System.out.print("Enter income: ");
                double income = scanner.nextDouble();

                System.out.print("Enter city: ");
                String city = scanner.next();

                System.out.print("Does the user have a 4-wheeler? (true/false): ");
                boolean hasFourWheeler = scanner.nextBoolean();

                user = new User(age, income, city, hasFourWheeler);
                user.validate();
                isValid = true;
                System.out.println("User is valid.");
            } catch (InvalidUserException e) {
                System.out.println("Invalid user: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }
    }
}
