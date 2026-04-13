import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_21029_JDBCQueryHandler_A01 {

    // Step 1: Establish a connection to the database
    private Connection connectToDatabase() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }

    // Step 2: Prepare and execute a SQL query
    public void executeQuery(String query) {
        Connection connection = connectToDatabase();
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.executeUpdate();
                System.out.println("Query executed successfully");
            } catch (SQLException e) {
                System.out.println("Failed to execute query");
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        System.out.println("Failed to close connection");
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        // This is an example of a security-sensitive operation. The actual query should be a secure one.
        handler.executeQuery("SELECT * FROM users WHERE username = ? AND password = ?");
    }
}