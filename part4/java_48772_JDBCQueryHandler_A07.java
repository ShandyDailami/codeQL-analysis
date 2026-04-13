import java.sql.*;
public class java_48772_JDBCQueryHandler_A07 {  
    public static void main(String[] args) {    
        String url = "jdbc:mysql://localhost/test"; // replace with your database URL and name     
        Connection conn;      
         try{          
             System.out.println("Connecting to the MySQL server...");         
              Class.forName('com.mysql.cj.jdbc.Driver');  /* driver location */                 
               if(conn = DriverManager.getConnection (url, "username", "password")) {   //replace username and password with your actual credentials    }                   else{     System.out.println("Failed to connect.");}      }}catch(ClassNotFoundException e){System.out.printlns ("MySQL JDBC driver not found");e.printStackTrace();}}         
         finally {conn = null;}   //Ensure we always close the connection, even if something goes wrong    }  System.outprintln("Connection closed.");}               }} catch (SQLException e){System. out . println ("An error occurred while connecting to MySQL");e.printStackTrace();}}