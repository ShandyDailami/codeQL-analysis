import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_40079_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a SQL command with parameterized queries
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "testuser");

            // Step 4: Execute the query
            // ...

            // Step 5: Close the connection
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}