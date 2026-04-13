import java.sql.*;   // imports needed Java libraries for database connectivity and manipulation

public class java_50995_JDBCQueryHandler_A01 {    
    private Connection conn = null; 
     
    public void connectToDatabase(String dbName, String userID, String password) throws SQLException{      
        try{        
            // Load the driver from your system library. Replace 'xxx' with actual name of .jar file containing JDBC Driver (e.g., mysql-connector-java.jar for MySQL database). 
             Class.forName("com.mysql.jdbc.Driver");  
              conn = DriverManager.getConnection( "jdbc:mysql://" + dbName, userID , password);       //Connecting to the Database   
        }catch (Exception e){         System.out.println ("Error in connecting database :  "+e) ;      return;     }  
          if (!conn.isValid(0)) {           conn = null;} else{System.out.println("Successfully connected");}               // Checking whether the connection is valid or not      
        }                catch (SQLException e){ throw new SQLException();}}  try      setAutoCommitFalse() ;   if (!conn.isValid(0)) { return;     }}         finally{finally block will execute no matter what, especially after 'try' and before exception handling code}      
           closeConnection(){    //closing the connection        }