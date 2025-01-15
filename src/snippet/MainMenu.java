package snippet;

import java.util.*;

public class MainMenu {

    static Scanner sc = new Scanner(System.in);

    public static List<User> users = new ArrayList<>(); // In-memory list for users
    public static List<Admin> admins = new ArrayList<>(); // In-memory list for admins

 
    static TheatreManager theatreManager = new TheatreManager();
    static MovieManager movieManager = new MovieManager();
    static Showtime showtimeManager = new Showtime();

    
    public static void userSignup() {
        System.out.println("Enter your username: ");
        String username = sc.next();

        System.out.println("Enter your password: ");
        String password = sc.next();

        System.out.println("Enter your name: ");
        String name = sc.next();

        System.out.println("Enter your phone number: ");
        String phone = sc.next();

        System.out.println("Enter your address: ");
        sc.nextLine(); // Clear buffer
        String address = sc.nextLine();

       
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists. Try a different one.");
                return;
            }
        }

        users.add(new User(name, username, password, address, phone));
        System.out.println("User registered successfully.");
    }

   
    static void userLogin() {
        System.out.println("Enter your username: ");
        String username = sc.next();

        System.out.println("Enter your password: ");
        String password = sc.next();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                user.userMenu(users.indexOf(user)); // Pass user ID (index in the list)
                return;
            }
        }

        System.out.println("Invalid username or password!");
    }

   
    static void adminSignup() {
        System.out.println("Enter your username: ");
        String username = sc.next();

        System.out.println("Enter your password: ");
        String password = sc.next();

        
        for (Admin admin : admins) {
            if (admin.getUsername().equals(username)) {
                System.out.println("Username already exists. Try a different one.");
                return;
            }
        }

        admins.add(new Admin(username, password, theatreManager, movieManager, showtimeManager));
        System.out.println("Admin registered successfully.");
    }

    
    public static void adminLogin() {
        System.out.println("Enter your username: ");
        String username = sc.next();

        System.out.println("Enter your password: ");
        String password = sc.next();

        for (Admin admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                System.out.println("Login successful!");
                admin.adminMenu();
                return;
            }
        }

        System.out.println("Invalid username or password!");
    }

    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n----- Movie Ticket Booking System -----");
            System.out.println("1. Sign up as user.");
            System.out.println("2. Login as user.");
            System.out.println("3. Sign up as admin.");
            System.out.println("4. Login as admin.");
            System.out.println("5. Exit.");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    userSignup();
                    break;
                case 2:
                    userLogin();
                    break;
                case 3:
                    adminSignup();
                    break;
                case 4:
                    adminLogin();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}