package Academy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class Helper {
    Formatting format = new Formatting();
    public void insertRecordTeacherAssignment(Connection connection, String table) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter " + table + "AssignmentID: ");
            String id = scanner.nextLine();
            System.out.print("Enter " + table + " TeacherID: ");
            String teacherID = scanner.nextLine();
            System.out.print("Enter " + table + " ClassID: ");
            String classID = scanner.nextLine();
            System.out.print("Enter " + table + " SubjectID: ");
            String subjectID = scanner.nextLine();
    
            String insertQuery = "INSERT INTO " + table + " VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, teacherID);
                preparedStatement.setString(3, classID);
                preparedStatement.setString(4, subjectID);
                preparedStatement.executeUpdate();
            }
            System.out.println("Record successfully inserted.");
        } catch (SQLException e) {
            System.err.println("Error inserting the record: " + e.getMessage());
        }
    }
	
    public void insertRecordSubjectAssignment(Connection connection, String table) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter " + table + "AssignmentID: ");
            String id = scanner.nextLine();           
            System.out.print("Enter " + table + " ClassID: ");
            String classID = scanner.nextLine();
            System.out.print("Enter " + table + " SubjectID: ");
            String subjectID = scanner.nextLine();
    
            String insertQuery = "INSERT INTO " + table + " VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, id);               
                preparedStatement.setString(2, classID);
                preparedStatement.setString(3, subjectID);
                preparedStatement.executeUpdate();
            }
            System.out.println("Record successfully inserted.");
        } catch (SQLException e) {
            System.err.println("Error inserting the record: " + e.getMessage());
        }
    }
    
    

    public void insertRecord(Connection connection, String table) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter " + table + " ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter " + table + " Name: ");
            String name = scanner.nextLine();
    
            String insertQuery = "INSERT INTO " + table + " VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.executeUpdate();
            }
            System.out.println("Record successfully inserted.");
        } catch (SQLException e) {
            System.err.println("Error inserting the record: " + e.getMessage());
        }
    }

    public void insertRecordWithTwoParameters(Connection connection, String table) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter Student ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Class ID: ");
            String classID = scanner.nextLine();
    
            String insertQuery = "INSERT INTO " + table + " VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, classID);
                preparedStatement.executeUpdate();
            }
            System.out.println("Student successfully added.");
            format.endPoint();
        } catch (SQLException e) {
            System.err.println("Error inserting the record: " + e.getMessage());
        }
    }

    public void deleteRecord(Connection connection, String table) {
        StringBuilder builder = new StringBuilder(table);
        builder.deleteCharAt(table.length() - 1);
        String databaseColumnName = builder.toString();
    
        if (table.equals("classes")) {
            databaseColumnName = "class";
        }
    
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter " + table + " ID: ");
            String id = scanner.nextLine();
    
            String deleteQuery = "DELETE FROM " + table + " WHERE " + databaseColumnName + "id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setString(1, id);
                preparedStatement.executeUpdate();
            }
            System.out.println("Record successfully deleted.");
        } catch (SQLException e) {
            System.err.println("Error deleting the record: " + e.getMessage());
        }
    }

    public void searchRecord(Connection connection, String table) {
        StringBuilder builder = new StringBuilder(table);
        builder.deleteCharAt(table.length() - 1);
        String databaseColumnName = builder.toString();
    
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter " + table + " ID: ");
            String id = scanner.nextLine();
    
            if (table.equals("classes")) {
                databaseColumnName = "class";
            }
    
            String query = "SELECT * FROM " + table + " WHERE " + databaseColumnName + "id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
    
                    if (resultSet.next()) {
                        do {
                            for (int i = 1; i <= columnCount; i++) {
                                String columnName = metaData.getColumnName(i);
                                String columnValue = resultSet.getString(i);
                                System.out.print(String.format("%-20s", columnName));
                            }
                            System.out.println();
    
                            do {
                                for (int i = 1; i <= columnCount; i++) {
                                    String columnValue = resultSet.getString(i);
                                    System.out.print(String.format("%-20s", columnValue));
                                }
                                System.out.println();
                            } while (resultSet.next());
    
                            System.out.println("==============================================================");
                            System.out.println("\n");
                        } while (resultSet.next());
                    } else {
                        System.out.println("Record not found.");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error searching for the record: " + e.getMessage());
        }
    }

    public void queryTable(Connection connection, String table) {
        System.out.println("==============================================================");
        System.out.println(table + " Table");
        try {
            String query = "SELECT  * FROM " + table;
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    System.out.print(String.format("%-20s", columnName));
                }
                System.out.println();
    
                while (resultSet.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        String columnValue = resultSet.getString(i);
                        System.out.print(String.format("%-20s", columnValue));
                    }
                    System.out.println();
                }
                System.out.println("==============================================================");
                System.out.println("\n");
            }
        } catch (SQLException e) {
            System.err.println("Error querying the table: " + e.getMessage());
        }
    }
}
