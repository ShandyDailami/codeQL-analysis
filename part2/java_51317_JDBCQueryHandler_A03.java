import java.sql.*;  // Importing JDBC driver interface  
/*Creates a simple connection to Oracle using only standard jdbc library */   
public class java_51317_JDBCQueryHandler_A03 {    
       static Connection con;      /* Declare the variable of type 'connection'*/       
 public void createSecureCon()         
           throws SQLException  // Throws exception if an error occurs  
         {              System.out.println("Connecting to a selected database...");   
                   String url="jdbc:oracle:thin:@localhost:1521:xe";      /* Define the URL as per requirement */    
                  con = DriverManager.getConnection(url,"username","password");   // Get Connection  and set User Name & Password       
                     }                System.out.println("Connected Successfully... ");    }}