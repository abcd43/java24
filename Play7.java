import java.util.Scanner;

class Player {
    protected String name;
    protected int age;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class CricketPlayer extends Player {
    private String team;

    public CricketPlayer(String name, int age, String team) {
        super(name, age);
        this.team = team;
    }

    public void display() {
        super.display();
        System.out.println("Team: " + team);
    }
}

class FootballPlayer extends Player {
    private String club;

    public FootballPlayer(String name, int age, String club) {
        super(name, age);
        this.club = club;
    }

    public void display() {
        super.display();
        System.out.println("Club: " + club);
    }
}

class HockeyPlayer extends Player {
    private String country;

    public HockeyPlayer(String name, int age, String country) {
        super(name, age);
        this.country = country;
    }

    public void display() {
        super.display();
        System.out.println("Country: " + country);
    }
}

public class Play7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details for Cricket Player:");
        System.out.print("Name: ");
        String cricketName = scanner.nextLine();
        System.out.print("Age: ");
        int cricketAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Team: ");
        String team = scanner.nextLine();

        System.out.println("\nEnter details for Football Player:");
        System.out.print("Name: ");
        String footballName = scanner.nextLine();
        System.out.print("Age: ");
        int footballAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Club: ");
        String club = scanner.nextLine();

        System.out.println("\nEnter details for Hockey Player:");
        System.out.print("Name: ");
        String hockeyName = scanner.nextLine();
        System.out.print("Age: ");
        int hockeyAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Country: ");
        String country = scanner.nextLine();

        CricketPlayer cricketPlayer = new CricketPlayer(cricketName, cricketAge, team);
        FootballPlayer footballPlayer = new FootballPlayer(footballName, footballAge, club);
        HockeyPlayer hockeyPlayer = new HockeyPlayer(hockeyName, hockeyAge, country);

        System.out.println("\nDetails of Cricket Player:");
        cricketPlayer.display();

        System.out.println("\nDetails of Football Player:");
        footballPlayer.display();

        System.out.println("\nDetails of Hockey Player:");
        hockeyPlayer.display();
    }
}
