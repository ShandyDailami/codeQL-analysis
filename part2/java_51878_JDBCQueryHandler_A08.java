import java.sql.*;
public class java_51878_JDBCQueryHandler_A08 {
    private static final String URL = "jdbcUrl"; // Put your jdbc url here 
    private static final String USERNAME ="username ";//Put Your Username Here  
     public static Connection conn;           
       try{       
         System.out.println("Connecting to database...");         
           if(conn == null || !conn.isValid()){              // Check whether the connection is valid or not   
             Class.forName ("driverClass");                  // Load JDBC driver here                
                                                                                                                    
                conn = DriverManager .getConnection (URL,USERNAME,"password ");  // Pass your password Here     
               if(conn != null) {                          System.out.println("Connected Successfully!");              }       else{         throw new Exception ("Failed to connect with MySQL Server");            }}     catch (Exception ex){        printStackTrace();   return;    }  // Error handling and end of method
                                                                                                                      
public static void main(String[] args) {                System.out.println("Running Query...");                        Connection con = conn;}                  try{                 PreparedStatement pstmt=conn .prepareCall ("your_query");              if (pstmt !=  null){    // execute your query here         }          catch  {}
   }}`;//End of main method and code. Please replace the placeholders with actual values or methods as per requirement for security sensitive operations related to integrity failure A08_IntegrityFailure . Make sure you have handle all exceptions properly in real world programming scenarios due your query might fail, be it because a non-existing table is being accessed , wrong SQL syntax etc.