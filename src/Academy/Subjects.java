package Academy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Subjects {
	//The class will handle subject requests
	
	public static void PerformActions(Connection connection) throws SQLException
	{
		 Menu mainMenu = new Menu();          
         Helper helper = new Helper();         
         boolean exitToMainMenu=false;
         Formatting format = new Formatting ();
         while (!exitToMainMenu) {
         int secondChoice = mainMenu.subjectsMenu();                       
         
         switch (secondChoice) {
             case 1:
            	 helper.insertRecord(connection, "subjects");                 
                 break; 
             case 2:
                 helper.queryTable(connection, "subjects");
                 break;                                
             case 3:
                 helper.searchRecord(connection, "subjects");
                 break;   

             case 4:
                 helper.insertRecordSubjectAssignment(connection, "subjectclassassignments");
                 break; 
             case 5:
                 helper.deleteRecord(connection, "subjects");
                 break;                 
             case 6:
                exitToMainMenu=true;
                 break;
             default:
                 System.out.print("Invalid Selection");
                 break;
         }  
		
		
		
	}
 

     
 
 
	}
}
