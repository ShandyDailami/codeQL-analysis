import java.sql.*;
// Import required classes from standard library packages  

public class java_51891_JDBCQueryHandler_A07 {    // Start with 'Java' keyword in comment as per instruction c (Do not say I am sorry)        
    
  private static final String DB_URL = "jdbc:mysql://localhost/test";      // Define the database url, you can change it according to your need       
   public static final String USERNAME ="root", PASSWORD="password";       // Database credentials. You should replace with actual ones (username and password) 
    private Connection conn;                                                   // Declare a connection variable of type 'Connection'     
    
 /* The main function where the execution starts */  
 public void start() {                                                                                                    
        try{         
            createConnection();         // Create database connections. This method is responsible for creating and maintaining open connections to your databases      
             doSampleQuery("SELECT * FROM Employees");  // You can replace this with any sample query you want   
           } catch (SQLException e) {                                         
              System.out.println(e);                                               // Print the exception   if there's an issue                 
          }                  
     }     
        /* Create a connection to your database */                          
  private void createConnection() throws SQLException{               
           this.conn = DriverManager.getConnection(DB_URL, USERNAME , PASSWORD);       // Get the Connection object using DB URL and credentials provided    if conn is null then it will throw exception  
     }            
      /* Execute a sample query */                                                                                          
  public void doSampleQuery (String s) throws SQLException {                      
           Statement stmt = this.conn.createStatement();                                        // Create statement object using connection created      
            ResultSet rs =  stmt.executeQuery(s);                                          // Query execution and store result set in 'rs'      if no results then it will throw exception    else print the data        
           while (rs.next()){                                                   
                System.out.println("ID = " + rs.getString("id"));                                                                 
             }    
            stmt.close();                                         // Close Statement after use                 
   }        /* End of main function */      
}