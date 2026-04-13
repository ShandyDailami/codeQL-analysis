import java.sql.*;   // Import the necessary classes needed for SQL Database operations 
                     and JDBC driver(s) to be used (like MySqlJDBCDriver, etc.)   
                     
public class java_51027_JDBCQueryHandler_A01 {     // Start of Class declaration section      
 public static void main(String[] args){        
   String url = "jdbc:mysql://localhost/test";  // Provide your MySQL server information here. This is a placeholder URL for simplicity only                    
   String username="root", password="password";//Provided by the user as placeholders, replace these with actual values       
    Connection conn;                      
     try {                     
       Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC Driver 
      System.out.println("\nConnecting to database...\n");  
         conn = DriverManager.getConnection(url, username , password);    
        if (conn != null) {            
          System.out.println("Successfully connected with DB!");             
           }  else{               //If connection is not established print message and exit from the program                     
            System.err.println("\nFailed to connect database! ");  
         }                 
      if (conn != null) {               
        Statement stmt = conn.createStatement();             
       String SQL = "SELECT * FROM Employee";     //Provide your query here for example select all from table employee   
            ResultSet rs = stmt.executeQuery(SQL);     
          while (rs.next()) {                      
           System.out.println("Data retrieved successfully.");  }         else{             
             System.err.println("\nFailed to retrieve data");   // In case of any error during retrieval print the message and exit from program                 
            }               conn.close();                            Connection close after use                     try {    ...     /* Ending Statement block */       if (conn != null) 
           System.out.println("Connection closed successfully.");         // Make sure to clean-up resources such as ResultSet, statement and connections here        }} catch(SQLException e){      } finally{          Prints error message regardless of the condition in try/catch blocks       if (conn != null) { conn.close();}   System.out.println("Connection closed successfully.");}}