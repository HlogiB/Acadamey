package Academy;

import java.sql.Connection;
import java.sql.SQLException;

public class Classes {
	public static void PerformActions(Connection connection) throws SQLException
	{
		 Menu mainMenu = new Menu();          
         Helper helper = new Helper();         
         boolean exitToMainMenu=false;
         Formatting format = new Formatting ();
         while (!exitToMainMenu) {
         int secondChoice = mainMenu.classMenu();                       
         format.outPut("classes");
         switch (secondChoice) {
             case 1:
            	 helper.insertRecord(connection, "classes");                 
                 break; 
             case 2:
                 helper.queryTable(connection, "classes");
                 break;                                
             case 3:
                 helper.searchRecord(connection, "classes");
                 break;                                
             case 4:
                 helper.deleteRecord(connection, "classes");
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
