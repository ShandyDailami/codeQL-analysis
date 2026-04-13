import java.sql.*;
public class java_51042_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost/test"; // replace with actual db url and name if different from local database server setup here for example, mysql connection URL should be changed accordingly to your own MySQL instance address. 
    private static final String USERNAME="root";//replace root according to the user in DB_URL (MySQL username)
    private static final String PASSWORD = "password"; // replace with actual password if different from local database server setup here for example, mysql connection Password should be changed accordingly 
    
   public Connection getConnection() throws SQLException {        
       return DriverManager.getConnection(DB_URL , USERNAME ,PASSWORD);       
    }         
}