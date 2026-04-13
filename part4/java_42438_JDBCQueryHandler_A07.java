import java.sql.*;   // Import required classes from package database   
public class java_42438_JDBCQueryHandler_A07 {     #Main Class where all other code is placed (begin)
        public static Connection connectToDatabase(){      /* Connect to Database */ 
                String url = "jdbc:mysql://localhost/test";      
		String username="root", password="password1234567890@#$%^&*()_+";   #Security sensitive operations related    
                 Connection conn = null;               //declaration of connection variable 
                try{                                /* Begin Try block */        
                        System.out.println("Connecting to database... ");       //Print statement for progress feedback       
			conn=DriverManager.getConnection(url,username,password);   #Creates a new Connection    return conn;     }catch (SQLException e){  /* Catch block when there's an error */             System.out.println("Something went wrong with database connection");      throw new SQLException();}      
        public static void main(String[] args) {                   # Main method that calls other methods   try{     connectToDatabase().closeConnection()    }catch (SQLExceptions e){              /* Catch block to handle exceptions */           System.out.println("Error: " +e);}}  // Error handling