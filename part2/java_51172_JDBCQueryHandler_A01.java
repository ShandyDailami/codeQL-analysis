import java.sql.*; // Import necessary Java packages  
// Class Declaration with SQLite Database Connection using JDBC   
public class java_51172_JDBCQueryHandler_A01 {    
      public static void main(String[] args) {         
        String url = "jdbc:sqlite:/home/user_data";  /* Path of the database file */        
            try (Connection conn = DriverManager.getConnection(url))             // Try-catch block for handling connection errors    
                  {   System.out.println("Successfully Connected to SQLite!");    }           catch (SQLException e)          {       System.err.println(e.getMessage());      }  */        /* End of Connection try/catch Block*/                 // Try-Catch block for handling exception in query execution    
                  {}                                                             finally         // Clean up action always happens, either successfully or unsuccessfully   Finally will run this code regardless the condition    { System.out.println("Closing connection"); if (conn != null) conn.close(); } catch (SQLException e){System.err.println(e);} 
                  }} //End of DBConnect class */         /* End Of Program */