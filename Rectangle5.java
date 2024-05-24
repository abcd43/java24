import java.util.Scanner;
public class Rectangle5 {
    private double width;
    private double length;
    private double area;
    private String colour;

    
    public Rectangle(double width, double length, String colour) {
        this.width = width;
        this.length = length;
        this.colour = colour;
        this.area = width * length;
    }


    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public String getColour() {
        return colour;
    }

 
    public static String compareRectangles(Rectangle rect1, Rectangle rect2) {
        if (rect1.area == rect2.area && rect1.colour.equals(rect2.colour)) {
            return "Matching Rectangles";
        } else {
            return "Non-matching Rectangles";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    
        System.out.println("Enter width of first rectangle:");
        double width1 = scanner.nextDouble();
        System.out.println("Enter length of first rectangle:");
        double length1 = scanner.nextDouble();
        System.out.println("Enter color of first rectangle:");
        String colour1 = scanner.next();

       
        Rectangle rect1 = new Rectangle(width1, length1, colour1);


        System.out.println("Enter width of second rectangle:");
        double width2 = scanner.nextDouble();
        System.out.println("Enter length of second rectangle:");
        double length2 = scanner.nextDouble();
        System.out.println("Enter color of second rectangle:");
        String colour2 = scanner.next();

        
        Rectangle rect2 = new Rectangle(width2, length2, colour2);

        
        String result = compareRectangles(rect1, rect2);
        System.out.println(result);

        scanner.close();
    }
}
