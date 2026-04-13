import java.sql.*;

public class java_00198_JDBCQueryHandler_A01 {

    // JDBC driver name and database URL
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    
    // Database credentials
    private static final String username = "username";
    private static final String password = "password";
    
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            // Load driver
            Class.forName(driver);
            
            // Open a connection
            connection = DriverManager.getConnection(url, username, password);
            
            // Create a statement
            statement = connection.createStatement();
            
            // Execute SQL query
            resultSet = statement.executeQuery("SELECT * FROM my_table");
            
            // Process the result set
            while (resultSet.next()) {
                System.out.println("Record 1: " + resultSet.getString("column1") + ", Record 2: " + resultSet.getString("column2"));
            }
            
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        } finally {
            // Close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}