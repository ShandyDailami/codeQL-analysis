import java.sql.*;  // Import required packages, includes SQL-related functionality in a form you can use without needing other third party dependencies e.g.: MySQL JDBC Driver & ResultSet objects (rs) etc...  
                   
public class java_52300_JDBCQueryHandler_A08 {                     
    public static void main(String[] args){  // Main method to run the code as a standalone application         
        String url = "YOUR_URL";           
        String username="USERNAME", password="PASSWORD";  
      
        try{                
           Connection conn =  DriverManager.getConnection (url,username ,password);  //Establishing connection with the database            
                   
          Statement stmt = null;              
                  if(conn !=  null){               
                      System.out.println("Connected to Database");                       
                          try{                           
                              String sqlQuery="YOUR_SQL";                         # Your SQL query here                     // Creating a statement from connection object  
                                  stmt = conn.createStatement();                  # Create the Statement          
                                   ResultSet rs =  stmt .executeQuery(sqlQuery);  # Executed Query on database           
                                      while (rs.next()) {                          # Iterate over results to print each row one by one                    
                                          String name=   rs.getString("name");        // Getting the value from column "Name" in current ResultSet line   
                                           System.out.println ("Student Name: " + name);  # Printing out Student's Names     
                                      }      
                              stmt .close();                                   # Closing Statement and Connection after use                           
                          }catch (SQLException sqlEx){                           // Catch the SQL Exception when executing query  
                                  System.out.println("Error occurred while running Query: "+sqlQuery);         
                                  printStackTrace(sqlEx);                         # Print out detailed exception information for debugging purpose 
                              }          
                      }                  
                  DriverManager.getDriver ("jdbc://someurl");                 // Returns the JDBC driver version           
                conn = null;                                               # Closing Connection after use             
          System.out.println("Connection closed!");                          # Print a message when connection is successfully connected, if it was not before                   }                  catch (SQLException se){                   
                                                                   // Catch SQL Exception for handling some errors  print out detailed exception information                e.printStackTrace();                             }}                 };`java' at the start and end of each code block respectively to indicate they are Java codes with comments removed as per your request, but still follow best practices in coding standards such as using descriptive names (e.g., 'conn', instead of just 'connection'), etc!