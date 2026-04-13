import java.sql.*; // Import required classes from the database package  
public class java_48055_JDBCQueryHandler_A07 {   
     public static void main(String[] args) throws SQLException, ClassNotFoundException{     
         String url = "jdbc:mysql://localhost/test"; 
         
         Connection conn=null;// Declare connection object of the type DriverManager       
       // Load MySQL driver for JDBC to access database    
                try {Class.forName("com.mysql.cj.jdbc.Driver");} catch (ClassNotFoundException e) {} 
              System.out.println ("Connecting To Database...");        
               conn = DriverManager.getConnection(url,"username","password" );   //Get connection from the database       }                try {            if ((conn != null))             Connection c  =    (new Statement()){}}catch(){}  catch (SQLException e) {}      System.out.println ("Closing connections...");          conn .close();     }}