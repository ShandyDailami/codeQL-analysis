import java.sql.*;

public class java_52733_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost/test"; // Replace with your own database url    
    private static final String USERNAME="root";  //Replace root as per the user on MySQL server;   You might need to change this based upon User Access. In my case, it's 'root'.     
    private static final String PASSWORD = "";// Replace with your password    
          
        public static void main(String[] args) {        
            try (Connection conn = DriverManager.getConnection(URL, USERNAME ,PASSWORD);  //Try and catch blocks are used for handling any exceptions in the block of code to avoid NullPointerException   ){   
                deleteUsersFromTable();            
              }catch(SQLException e){    
               System.out.println("Error while connecting to database");     
	          e.printStackTrace();  //Handling exception by printing Stack Trace       
		         }           
	}      
  
    private static void deleteUsersFromTable() {            
	    String sql = "DELETE FROM Users WHERE id > 5";          
	        try (Statement stmt = conn.createStatement()) {                     
	          int rowsDeleted = stmt.executeUpdate(sql);                  
		        System.out.println("Rows deleted: " + rowsDeleted );     //Print number of row/s that has been successfully updated in the database    } catch (SQLException e) {} 
	        };   /* end try block */                     
      });             /***end main***/      
}