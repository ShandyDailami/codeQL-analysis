import java.sql.*;   // Import necessary Java SQL classes 

public class java_47585_JDBCQueryHandler_A07 {   
      
 static final String URL = "jdbc:mysql://localhost/test";    
// Change the server name, database and username to match yours     
 static final String USERNAME="root";       
 private static final String PASSWORD =  "password@1234567890"; //Change password here 
    public Connection connection;  
      
     /* This method establishes a new database connection */        
            boolean createConnection() {     
                try{              
                    this.connection = DriverManager.getConnection(URL,USERNAME ,PASSWORD);                 
                     return true ;          }           catch (SQLException e){        // Handle any SQL exception  
                      System.out.println("Error in establishing connection to the database");    printStackTrace();     return false;       }}  */}                };