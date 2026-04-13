import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_01231_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            connection = DriverManager.getConnection(url, username, password);
            
            // Prepare SQL query
            String query = "SELECT * FROM Users WHERE UserID = ?";
            preparedStatement = connection.prepareStatement(query);
            
            // Set user ID as parameter
            preparedStatement.setInt(1, 123);
            
            // Execute query
            preparedStatement.execute();
            
            // Process results...
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}