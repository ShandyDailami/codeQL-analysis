import java.sql.*;

public class java_51250_JDBCQueryHandler_A01 {
    public static final String URL = "jdbc:mysql://localhost/test"; // replace with your DB url and name, assuming you're using MySQL as the db type here for simplicity sake
    
    private Connection connection; 
  
    /** Establish a database connection. */
    void connect() {      
        try{           
             Class.forName("com.mysql.cj.jdbc.Driver"); // assuming driver available in classpath and named as 'com.mysql.cj.jdbc' for simplicity sake 
              this.connection = DriverManager.getConnection(URL, "username", "password" );// replace with your username & password   
        }catch (Exception e){         System.out.println("Error while connecting to database");     	e.printStackTrace();}      		  			            	} 	   									    	 	       ` ` ``