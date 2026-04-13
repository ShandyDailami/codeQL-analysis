import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_21514_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare SQL statement
            String sql = "INSERT INTO Users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Step 4: Execute SQL statement
            statement.setString(1, "newuser");
            statement.setString(2, "password");
            statement.executeUpdate();

            // Step 5: Close connection
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}