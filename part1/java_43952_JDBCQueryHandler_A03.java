import java.sql.*;   // For ResultSet, Statement & Connection objects   
    
public class java_43952_JDBCQueryHandler_A03 {     
         private static final String URL = "jdbc:mysql://localhost/test";      
        private static final String USERNAME="root";         
        private static final String PASSWORD="password1234@abcd!";     // replace with your own password 
            
      public Connection connectToDatabase() {           
           try{               
               return DriverManager.getConnection(URL,USERNAME,PASSWORD);              }                      catch (SQLException e)   {}         finally{}                 };