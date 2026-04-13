import java.sql.*;  // Import required Java libraries for SQL connectivity, like JDBC and ResultSet interface etc...   
public class java_52872_JDBCQueryHandler_A01 {    
   public static void main(String[] args) throws ClassNotFoundException, SQLException{        
       String url = "jdbc:mysql://localhost/testdb";  // Specify database URL here. Replace with your actual DB details...         
       Connection connection;     
        Statement statement ;   
    
           try {           
               System.out.println("Connecting to the MySQL server....");            
                Class.forName('com.mysql.cj.jdk.x.x'); // Loads mysql driver             
                
                  connection = DriverManager.getConnection(url, "username", "password" );  // Replace with your actual username and password...              
                   statement  =connection .createStatement();         
             System.out.println("Connected to database");            }           catch (Exception ex){     ConsoleLoggerExample   ,ex);    return;      }}