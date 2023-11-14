package Academy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class Report {
	public static void PerformActions(Connection connection) throws SQLException
	{
		 Menu mainMenu = new Menu();          
         Helper helper = new Helper();         
         boolean exitToMainMenu=false;
         Formatting format = new Formatting ();
         while (!exitToMainMenu) {
         int secondChoice = mainMenu.reportsMenu();                       
         
         switch (secondChoice) {
          case 1:
                helper.queryTable(connection, "classreport");
                 break;
          case 2:
        	  classReportOnID(connection, "classreport");
               break;
                 
          case 3:
        	  exitToMainMenu=true;
        	  break;
             default:
                 System.out.print("Invalid Selection");
                 break;
         }  
         
      }
		
		
		
	}
         
         
         
         public static void classReportOnID(Connection connection, String table) {
        	 Scanner scanner = new Scanner(System.in);
        	 System.out.println("==============================================================");
             System.out.print("Enter " + table + " ID: ");
             String id = scanner.nextLine();
             System.out.println(table.toUpperCase() + " Table");
             try {
                 String query = "SELECT * FROM " + table+" where classid='"+id+"'";
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
