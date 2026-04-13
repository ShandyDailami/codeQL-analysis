import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_15790_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Step 1: Establish a connection to the database
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            
            // Step 2: Perform a query
            String query = "SELECT * FROM users WHERE role = 'admin'";
            ResultSet resultSet = statement.executeQuery(query);
            
            // Step 3: Process the result set
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
            
            // Step 4: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}