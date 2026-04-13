import java.sql.*;
public class java_50863_JDBCQueryHandler_A08 {     //Class name is "VanillaJava" for legibility's sake, you can use any other suitable naming convention (e.g., 'SecureDatabaseConnection') as per your project requirements and conventions 
    private static final String URL = "your_database_url";     
    private static final String USERNAME= "username here" ;     // Provide a username for the database user; keep it secret or provide empty string if no need to enter credentials.   For example: "" (empty)  --> use default SQL server authentication, not recommended unless you have explicit access rights
    private static final String PASSWORD = "password here";      /*Provided password used by your connection and user for the database security; keep it secret or provide empty string if no need to enter credentials.   For example: "" (empty)  --> use default SQL server authentication, not recommended unless you have explicit access rights
    public static Connection getConnection() throws SQLException {      //This method returns a new connection with your DB and handles exceptions related the database connectivity problems    
        return DriverManager.getConnection(URL , USERNAME, PASSWORD);   /*Returning this 'connection' object will allow you to interact directly with databases*/ 
    }                                                                      
}