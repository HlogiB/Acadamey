package Academy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Students {
	//The class will handle student requests	
	
	public static void addNewStudent(Connection connection) throws SQLException
	{
		System.out.print("==============================================\n");
		Helper helper = new Helper();            
        System.out.println("Student information inserted successfully.");      
	}	
	
	
	public static void PerformActions(Connection connection) throws SQLException
	{
		 Menu mainMenu = new Menu();          
         Helper helper = new Helper();         
         boolean exitToMainMenu=false;
         Formatting format = new Formatting ();
		
         while (!exitToMainMenu) {
       
         int secondChoice = mainMenu.studentsMenu();                       
        
         switch (secondChoice) {
             case 1:
            	 helper.insertRecordWithTwoParameters(connection, "Students");                 
                 break; 
             case 2:
                 helper.queryTable(connection, "Students");
                 break;                                
             case 3:
                 helper.searchRecord(connection, "Students");
                 break;                                
             case 4:
                 helper.deleteRecord(connection, "Students");
                 break;                 
             case 5:
                exitToMainMenu=true;
                 break;
             default:
                 System.out.print("Invalid Selection");
                 break;
         }  
		
		
		
	}
	
	
	


}}