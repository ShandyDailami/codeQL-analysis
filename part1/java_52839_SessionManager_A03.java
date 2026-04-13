import java.sql.*;  // Import statements only needed here in this example for simplicity of implementation - remove if real requirement is met above
public class java_52839_SessionManager_A03 {  
    private Connection connection;     
     public void openConnection(String dbURL, String userName , String password) throws SQLException{      
        try {connection = DriverManager.getConnection(dbURL,userName,password);}  // Creates a new database connectivity object and sets up the URL/Credentials for Database Connection    } catch (SQLException e1){e1.printStackTrace();}}           private void close() throws SQLException{if ((connection != null)) { connection.close(); }}