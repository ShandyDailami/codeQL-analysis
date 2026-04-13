import java.sql.*;   // Import necessary Java libraries for JDBC 
    import javax.sql.DataSource;     // For Data Source Interface that is used by Connection object to access data source such as MySQL DB etc..

public class java_44700_JDBCQueryHandler_A03 {      // Create a new Class named 'VanillaJava'  
private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=MyDatabase";    // Database Details. You need to replace these with your actual details 
private static final String USERNAME = "";     // User Name of the database user you created, it is empty as we are using windows authentication  
private static final String PASSWORD  =" ";      // Password for above username; typically stored in a secure manner (can be an environment variable) or hidden/masked  etc. Empty string used here also because no password was provided while creating user with SQL Server database   
    
public Connection getConnection() throws SQLException {       /* Create method to return connection */   // We use try-catch block so that if there is any issue it can be handled in the catch section of code 
        Connection conn = DriverManager.getConnection(URL, USERNAME , PASSWORD);    
        System.out.println("Connected Successfully");     
         return conn;    // Returning connection object so that we use this later on for execution          }   */             /* End of getconnection method  and closing brace*/       catch (SQLException e) {e.printStackTrace(); throw new SQLException( );} });     System.out.println("Can't find JDBC driver");     
    }} // Closing curly braces for the main class   Java is case sensitive so you need to make sure that your code matches with classes and methods in java jdbc drivers  */