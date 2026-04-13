import java.sql.*;   // Import the necessary classes from JDBC package 
// Create a connection to an SQL Server DB instance: "jdbc:mysql://<server_name>/mydatabase?useSSL=false"    (Use SSL if you have one)
public class java_51914_JDBCQueryHandler_A08 {    
   public static void main(String[] args){  // Main method begins execution of Java application. Here we create a connection to the database and then run our SQL command, print out results in console etc...         
       String url = "jdbc:mysql://localhost/mydatabase?useSSL=false";    
      String username ="username_here";   // your MySQL user name here    ,  password is 'password' if you have set it up with the server.         /* Use credentials to connect */               
       try {                                  // Create a connection object using JDBC        . (Connection Object)                      
           Connection con  = DriverManager.getConnection(url,username,"");    
          System.out.println("Connected successfully ");      }                  catch  (SQLException e){   /* if you are not connected then print the exception */                    // Print out SQL Exception message         .    for example: "Incorrect username or password"       });        }}`              ******//** A08_IntegrityFailure.java ends here