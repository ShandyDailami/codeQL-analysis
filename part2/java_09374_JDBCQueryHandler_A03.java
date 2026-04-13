import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_09374_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare SQL query
            String query = "SELECT * FROM users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 4: Set parameter value
            statement.setString(1, "test@example.com");

            // Step 5: Execute the query
            statement.executeUpdate();

            // Step 6: Close the connection
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}