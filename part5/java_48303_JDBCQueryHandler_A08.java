import java.sql.*; // Import Statements For Java Database Connectivity Interface  
// Useful import statement that allows us get access from the database using JDBC API   

public class java_48303_JDBCQueryHandler_A08 {    
        public static void main(String[] args)  throws SQLException{        
            String url = "jdbc:mysql://localhost/testdb"; // Specify your DB URL here  
            String username ="root";// Use root user for simplicity, replace it with the actual one.   
             Connection con= null;    
                  try {       //Try block to catch exceptions which are handled in this code     
                          System.out.println("Connecting Database");       
                              /*Create a connection */         
                 con = DriverManager.getConnection(url,username,"password_here") ;        
                               if (con != null) {       //Check the Connection to DB is not empty  
                                   System.out.println("Database Connected Successfully!");        } else{     
                                        throw new Exception ("Cannot connect Database ");    }}catch(Exception e){     /* Catch block when exception happens */         System.err.print (e.getMessage());  // print the error message on console       return;}}}}}   catch-block is used to handle exceptions raised by statements in a try-statement or method call if some part of it fails due       
to an unhandled Exception e which we can't recover from, and that are not checked as Exceptions but rather have been thrown at the point where they might be detected.  For example: OutOfMemoryError etc., SQLException for database errors such as table doesn’t exist or you trying to access a nonexistent column in your tables