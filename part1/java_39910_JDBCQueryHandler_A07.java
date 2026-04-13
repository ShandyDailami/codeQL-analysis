import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_39910_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");

            // Prepare a statement
            Statement statement = connection.createStatement();

            // Run a query
            String sql = "SELECT * FROM users WHERE username = 'testuser' AND password = 'testpassword'";
            statement.executeQuery(sql);

            // Close the statement and connection
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}