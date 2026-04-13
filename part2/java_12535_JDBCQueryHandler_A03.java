import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_12535_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Step 1: Establish a Connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            // Step 2: Execute a Query
            String query = "INSERT INTO my_table (column1, column2) VALUES ('value1', 'value2')";
            statement.executeUpdate(query);

            // Step 3: Close the Connection
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}