import java.sql.*;  // Import the necessary Java SQL packages  
import javax.naming.*;// for JNDI (Java Naming and Directory Interface) - not strictly needed, only if you have a context or connection pool setup in your application using EJB/CDI container   
    
public class java_48957_JDBCQueryHandler_A03 {  // Define the main method to execute our program  
        
        public static void connectToDatabase(String databaseURL){      
            try{                     
                Connection conn = DriverManager.getConnection("jdbc:mysql://" +databaseURL, "username", "password");   
                         
                 System.out.println("\nConnected to the Database!");                  
                  }  catch (SQLException ex) {         // Catch any SQL Exceptions         
                    System.err.format("SQL Exception Occurred: %s\n",ex);           
                            ex.printStackTrace();                               
                          return;                                  
                 }     finally{  
                try { conn.close() ;}  catch (Exception e){e.printStackTrace();}}       // Always close the connection, regardless of what happens in a nested block   
        }          
         public static void main(String args[]) throws Exception                     // Define our Main method           
                  {                                                                  
                        String databaseURL = "localhost:3306/mydatabase";      // Provide your own Database URL if needed, this is just an example            
                          connectToDatabase (databaseURL);         }           });          };