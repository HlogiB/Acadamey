package Academy;

import java.util.Scanner;

public class Menu {
    Scanner sn = new Scanner(System.in);

    // Display the main menu options
    public void displayMainMenu() {
        System.out.println("\n1. Teachers Portal");
        System.out.println("2. Students Portal");
        System.out.println("3. Subjects Portal");
        System.out.println("4. Classes Portal");
        System.out.println("5. Report Portal");
        System.out.println("6. Exit");
    }
    public int reportsMenu()
    { try {
        System.out.println("1. View all classes report ");
        System.out.println("2. View by each class report");        
        System.out.println("3. Back to main menu");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    } catch (Exception e) {
        System.err.println("Error: Invalid input. Please enter a valid choice.");
        return -1; // Return an error code
    }
}
    
    // Get the user's choice for the Teachers Portal menu
    public int teachersMenu() {
        try {
            System.out.println("1. Add new teachers");
            System.out.println("2. View teachers");
            System.out.println("3. Search teacher");
            System.out.println("4. Assign teachers to classes");
            System.out.println("5. Delete teacher");
            System.out.println("6. Back to main menu");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            return choice;
        } catch (Exception e) {
            System.err.println("Error: Invalid input. Please enter a valid choice.");
            return -1; // Return an error code
        }
    }

    // Get the user's choice for the Students Portal menu
    public int studentsMenu() {
        try {
            System.out.println("1. Add new students");
            System.out.println("2. View students");
            System.out.println("3. Search students");
            System.out.println("4. Delete student");
            System.out.println("5. Back to main menu");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            return choice;
        } catch (Exception e) {
            System.err.println("Error: Invalid input. Please enter a valid choice.");
            return -1; // Return an error code
        }
    }

    // Get the user's choice for the Subjects Portal menu
    public int subjectsMenu() {
        try {
            System.out.println("1. Add new subjects");
            System.out.println("2. View subjects");
            System.out.println("3. Search subjects");
            System.out.println("4. Assign subjects to classes");
            System.out.println("5. Delete subjects");
            System.out.println("6. Back to main menu");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            return choice;
        } catch (Exception e) {
            System.err.println("Error: Invalid input. Please enter a valid choice.");
            return -1; // Return an error code
        }
    }

    // Get the user's choice for the Classes Portal menu
    public int classMenu() {
        try {
            System.out.println("1. Add new class");
            System.out.println("2. View classes");
            System.out.println("3. Search classes");
            System.out.println("4. Delete classes");
            System.out.println("5. Back to main menu");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            return choice;
        } catch (Exception e) {
            System.err.println("Error: Invalid input. Please enter a valid choice.");
            return -1; // Return an error code
        }
    }
}
