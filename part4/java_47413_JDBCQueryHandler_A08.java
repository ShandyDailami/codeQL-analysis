import java.sql.*;   // Import the necessary Java database classes: Connection, PreparedStatement etc.,   
    
public class java_47413_JDBCQueryHandler_A08 {      // Define a new public static inner-class named 'JDBCQueryHandler' in VanillaJava to hold our methods and fields 
            
private String driverClass = "com.mysql.cj.jdbc.Driver";   // The database driver that we are going use, you can change it according your needs   
     private Connection conn;                                                       // Database connection object       
          
public void establishConnection(String url ,  String username , String password) {       // Method to connect the DB        
      try{                   
          Class.forName(driverClass);                  // Loading JDBC driver for MySQL or any other database you are using  
     conn = DriverManager.getConnection(url,username,password );             // Getting a connection object and assign it with URL details 
       }catch (Exception e){                          // Catch block to handle exceptions                  
          System.out.println("Could not establish Connection: " +e);    // Print the error message if exception occurred  
      }}          
     public ResultSet executeQuery(String query) {                         // Method for executing Query      
         try{                                                       // Try-catch block to handle exceptions 
             PreparedStatement pstmt = conn.prepareStatement (query );          // Preparing SQL statement using connection object   
              return pstmt.executeQuery();                           // Execute the preparedstatement and get result set from database  
           } catch(SQLException e) {                                // Catch block to handle exceptions  if there is any exception in try-catch blocks    
               System.out.println("Could not execute query: " +e);        // Print error message on console     
         return null;                                             // Return Null as we have nothing after this operation   }    catch (Exception e){...}          }  Finally block to close the connection is optional, but recommended       try { conn.close(); }}catch(SQLException se){se.printStackTrace()};     finally{}}