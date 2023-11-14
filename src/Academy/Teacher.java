package Academy;

import java.sql.Connection;
import java.sql.SQLException;

public class Teacher {
	public static void PerformActions(Connection connection) throws SQLException
	{
		 Menu mainMenu = new Menu();          
         Helper helper = new Helper();         
         boolean exitToMainMenu=false;
         Formatting format = new Formatting ();
         
         while (!exitToMainMenu) {
        	 format.outPut("teachers");
         int secondChoice = mainMenu.teachersMenu();                       
         
         switch (secondChoice) {
             case 1:
            	 helper.insertRecord(connection, "teachers");                 
                 break; 
             case 2:
                 helper.queryTable(connection, "teachers");
                 break;                                
             case 3:
                 helper.searchRecord(connection, "teachers");
                 break;    
             case 4:
                 helper.insertRecordTeacherAssignment(connection, "teacherclassassignments");
                 break;
             case 5:
                 helper.deleteRecord(connection, "teachers");
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
