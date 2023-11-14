package Academy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminPage {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/learners_academy";
        String username = "root";
        String password = "#Elebaby";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            Students student = new Students();
            Teacher teacher = new Teacher();
            Subjects subjects = new Subjects();
            Menu mainMenu = new Menu();
            Classes classes = new Classes();
            Helper helper = new Helper(); // This class holds common methods
            Formatting format = new Formatting(); // This class holds formatting methods
            boolean exit = false;

            System.out.println("Learner's Academy Database Menu");
            System.out.println("==============================================================");

            while (!exit) {
                
                System.out.println("Main Administrative Portal ");
                System.out.println("\nWhere would you like to go😊");
                mainMenu.displayMainMenu();
                //System.out.println("\n");
                System.out.print("Enter your choice: ");

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                scanner.nextLine();

                try {
                    switch (choice) {
                        case 1:
                        	//format.outPut("teachers");
                            teacher.PerformActions(connection);
                            
                            break;
                        case 2:
                            format.outPut("students");
                            student.PerformActions(connection);
                            //format.endPoint();
                            break;
                        case 3:
                        	format.outPut("subjects");
                            subjects.PerformActions(connection);
                            //format.endPoint();
                            break;
                        case 4:
                        	format.outPut("classes");
                            classes.PerformActions(connection);
                            //format.endPoint();
                            break;
                        case 5:
                        	format.outPut("Report");
                            Report.PerformActions(connection);
                            //format.endPoint();
                            break;
                        case 6:
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                } catch (SQLException e) {
                    System.err.println("Error: " + e.getMessage());
                }
                format.endPoint();
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
}
