import java.sql.*;   // Import necessary Java SQL classes   
public class java_46264_JDBCQueryHandler_A07 {     // Declare the main class name     
       public static void main(String[] args)throws Exception{        // Main method which will execute everything here         
         Connection conn = null;             // Initialize a connection object to hold database connections  
                try   
                 {                  // Start of 'try' block: Attempt all the following operations within this scope    
                   Class.forName("com.mysql.cj.jdbc.Driver");       // Load MySQL Driver for JDBC Connection, replace with appropriate driver if different 
                    conn = DriverManager.getConnection( "dburl", "username","password" );        // Get a connection to the database    
                     System.out.println("Connected successfully!");         
                      String sql="SELECT * FROM your_table";             // Create SQL query, replace with actual table name and operation 
                    Statement stmt = conn.createStatement();            // Initialize statement object  
                  ResultSet rs =stmt.executeQuery(sql );               // Execute the given Query to fetch data from database    
                 while (rs.next())           // Process fetched row one by-one     
                   {                         // Start of 'while' loop block      
                     String name= rs.getString("name");             // Get value for specific column, replace "column_name" with actual  data source   
                       System.out.println(name);                    // Print out the fetched values    
                      }                           // Ending of 'while' loop block      
                 conn.close();                            // Close connection object when done        
                }         
               catch (Exception ex)             // Catch exceptions if any occur in try-catch blocks       
                  {          
                    System.out.println("Error while connecting to DB");   
                     ex.printStackTrace(); 
                   }      
     }}