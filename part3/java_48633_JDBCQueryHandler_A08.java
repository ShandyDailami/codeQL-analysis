import java.sql.*;  // Import Statements from Java libraries used in this program   
  
public class java_48633_JDBCQueryHandler_A08 {    
      private static Connection con = null;       // Declare a global variable to hold database connections for thread safety (Recommend using connection pool)       
            
      public void establishConnection(String dbURL, String username,  char[] password){         
           try{           
              /* Establish the Database connection */               
                  con = DriverManager.getConnection(dbURL ,username,password);              
                   System.out.println("Successfully connected to database!" );  
         }catch (SQLException e) {                     // Catching SQL Exceptions for handling exceptions                   
              /* Handle the exception if any occurred */               
                  System.err.format("SQL Exception: %s", e);                       
           }    
      } 
       
       public void executeQuery(String query){         
         try{            // Try to run a statement on database   
             Statement stmt = con.createStatement();               // Create the SQL Query  
              ResultSet rs  = stmt.executeQuery("select * from Employee");      /* Execute SELECT */       
                    while (rs.next()) {                 
                       System.out.println( "Name : " + rs.getString("name"));     // Print Name of the employee  }                  
         )catch (SQLException e){              // Catching SQL Exceptions for handling exceptions                    
             /* Handle exception if any occurred */              
                out.printStackTrace();                          
        }}