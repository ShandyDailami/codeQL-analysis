import java.sql.*;

public class java_45549_JDBCQueryHandler_A03 {
    private static final String url = "jdbcUrl"; // Replace with your actual database URL
    private static final String username ="userName ";//Replace user name and password by using environment variable or secure method to store them 
   private static final String password="password"; ///Again, replace it as per requirement. Store in the code rather than hardcoding here for security reasons     //Also use JDBCEnvironmentVariablesProvider class if you want more robust way of handling these sensitive data points (A01_Security) 
   private static Connection connection;       
    public void connectToDatabase(){       ///Using Singleton Design Pattern to maintain only one instance and thus prevent multiple connections. If we have any other database operations, then it will be done through this method     //Also use a DatabasePoolingProvider Class if more than 1 DB is required (A02_Connection Pool)
        try {       ///Create Connection using JDBC Driver API     
            connection =DriverManager.getConnection(url , username , password);          
             System.out.println("Connected to database");    }   catch (SQLException e){              //Handle SQL Exception properly for a robust program  A06_Error Handling       ///Recommend using the Logger API instead of Console Print Statements in real world applications    
            e.printStackTrace();}                    }}