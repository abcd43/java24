import java.util.ArrayList;
import java.util.Scanner;

class Student {
    protected String name;
    protected int rollNumber;
    protected String subject;

    public Student(String name, int rollNumber, String subject) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subject = subject;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Subject: " + subject);
    }

    public void editDetails(String name, int rollNumber, String subject) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getSubject() {
        return subject;
    }

    public boolean searchRecord(String searchKey) {
        return name.equalsIgnoreCase(searchKey) || String.valueOf(rollNumber).equals(searchKey);
    }
}

class DerivedStudent extends Student {
    private String subjectCode;
    private int internalAssessment;
    private int universityMarks;

    public DerivedStudent(String name, int rollNumber, String subject, String subjectCode, int internalAssessment, int universityMarks) {
        super(name, rollNumber, subject);
        this.subjectCode = subjectCode;
        this.internalAssessment = internalAssessment;
        this.universityMarks = universityMarks;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Subject Code: " + subjectCode);
        System.out.println("Internal Assessment Marks: " + internalAssessment);
        System.out.println("University Examination Marks: " + universityMarks);
    }

    public void editDetails(String name, int rollNumber, String subject, String subjectCode, int internalAssessment, int universityMarks) {
        super.editDetails(name, rollNumber, subject);
        this.subjectCode = subjectCode;
        this.internalAssessment = internalAssessment;
        this.universityMarks = universityMarks;
    }
}

public class StudentRecord10 {
    private static ArrayList<Student> masterTable = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Build Master Table");
            System.out.println("2. List Table");
            System.out.println("3. Insert New Entry");
            System.out.println("4. Delete Old Entry");
            System.out.println("5. Edit Entry");
            System.out.println("6. Search for a Record");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    buildMasterTable(scanner);
                    break;
                case 2:
                    listTable();
                    break;
                case 3:
                    insertNewEntry(scanner);
                    break;
                case 4:
                    deleteOldEntry(scanner);
                    break;
                case 5:
                    editEntry(scanner);
                    break;
                case 6:
                    searchRecord(scanner);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        } while (choice != 7);
    }

    private static void buildMasterTable(Scanner scanner) {
        System.out.println("Building Master Table...");
        masterTable.clear(); // Clear existing table

        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Roll Number: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Subject: ");
            String subject = scanner.nextLine();
            System.out.print("Subject Code: ");
            String subjectCode = scanner.nextLine();
            System.out.print("Internal Assessment Marks: ");
            int internalAssessment = scanner.nextInt();
            System.out.print("University Examination Marks: ");
            int universityMarks = scanner.nextInt();

            DerivedStudent student = new DerivedStudent(name, rollNumber, subject, subjectCode, internalAssessment, universityMarks);
            masterTable.add(student);
        }

        System.out.println("Master Table built successfully.");
    }

    private static void listTable() {
        System.out.println("\nListing Master Table:");
        if (masterTable.isEmpty()) {
            System.out.println("Master Table is empty.");
        } else {
            for (Student student : masterTable) {
                student.displayDetails();
                System.out.println();
            }
        }
    }

    private static void insertNewEntry(Scanner scanner) {
        System.out.println("Inserting New Entry...");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Subject: ");
        String subject = scanner.nextLine();
        System.out.print("Subject Code: ");
        String subjectCode = scanner.nextLine();
        System.out.print("Internal Assessment Marks: ");
        int internalAssessment = scanner.nextInt();
        System.out.print("University Examination Marks: ");
        int universityMarks = scanner.nextInt();

        DerivedStudent student = new DerivedStudent(name, rollNumber, subject, subjectCode, internalAssessment, universityMarks);
        masterTable.add(student);

        System.out.println("New entry inserted successfully.");
    }

    private static void deleteOldEntry(Scanner scanner) {
        System.out.println("Deleting Old Entry...");
        System.out.print("Enter name or roll number to delete: ");
        String searchKey = scanner.nextLine();

        boolean found = false;
        for (Student student : masterTable) {
            if (student.searchRecord(searchKey)) {
                masterTable.remove(student);
                found = true;
                break; // Exit loop after deleting first occurrence
            }
        }

        if (found) {
            System.out.println("Entry deleted successfully.");
        } else {
            System.out.println("Entry not found.");
        }
    }

    private static void editEntry(Scanner scanner) {
    System.out.println("Editing Entry...");
    System.out.print("Enter name or roll number to edit: ");
    String searchKey = scanner.nextLine();

    boolean found = false;
    for (Student student : masterTable) {
        if (student.searchRecord(searchKey)) {
            if (student instanceof DerivedStudent) {
                DerivedStudent derivedStudent = (DerivedStudent) student; 

                System.out.println("Enter new details:");
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Roll Number: ");
                int rollNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Subject: ");
                String subject = scanner.nextLine();
                System.out.print("Subject Code: ");
                String subjectCode = scanner.nextLine();
                System.out.print("Internal Assessment Marks: ");
                int internalAssessment = scanner.nextInt();
                System.out.print("University Examination Marks: ");
                int universityMarks = scanner.nextInt();

                derivedStudent.editDetails(name, rollNumber, subject, subjectCode, internalAssessment, universityMarks);
            } else {
                System.out.println("Cannot edit details for base Student class.");
            }
            found = true;
            break; // Exit loop after editing first occurrence
        }
    }

    if (found) {
        System.out.println("Entry edited successfully.");
    } else {
        System.out.println("Entry not found.");
    }
}


    private static void searchRecord(Scanner scanner) {
        System.out.print("Enter name or roll number to search: ");
        String searchKey = scanner.nextLine();

        boolean found = false;
        for (Student student : masterTable) {
            if (student.searchRecord(searchKey)) {
                System.out.println("Record found:");
                student.displayDetails();
                found = true;
                break; // Exit loop after finding first occurrence
            }
        }

        if (!found) {
            System.out.println("Record not found.");
        }
    }
} 

