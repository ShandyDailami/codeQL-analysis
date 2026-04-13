import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_35977_JDBCQueryHandler_A07 {
    private static final Logger logger = Logger.getLogger(JDBCQueryHandler.class.getName());
    private static Connection connection = null;
    private static Statement statement = null;
    
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";
        
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            
            String query = "SELECT * FROM users WHERE id = ?";
            ResultSet result = statement.executeQuery(query);
            
            while (result.next()) {
                logger.log(Level.INFO, "User id: " + result.getString("id"));
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Failed to connect to database.", ex);
        } finally {
            closeConnection();
        }
    }
    
    private static void closeConnection() {
        try {
            if (statement != null)
                statement.close();
            
            if (connection != null)
                connection.close();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Failed to close connection.", ex);
        }
    }
}