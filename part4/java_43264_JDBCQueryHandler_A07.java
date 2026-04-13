import java.sql.*;

public class java_43264_JDBCQueryHandler_A07 {     // Assuming this will serve to handle our query requests for A07_AuthFailure 
    private static final String DB_URL = "yourdburl";  
    private static final String USERNAME =  "usernameforDbconnection" ;        
    private static final String PASSWORD  = "passwordforYourDatabaseConnection ";      // Insert your password here       
    
       public Connection connectToDB() {  //Establishes a connection to the database. This is done using JdbcDriverManager from java.sql package  
           try{         
               Class.forName("com.mysql.cj.jdbc.Driver");      //Loads MySQL driver for Java Database connectivity        
                Connection con = DriverManager.getConnection(DB_URL, USERNAME , PASSWORD);  //Creates a connection to the database          
                 return con;   //Returns this connections object which we can use in further steps       }            catch (SQLException | ClassNotFoundException e) {     throw new RuntimeException("Cannot connect DB : ",e );      }}