import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_32370_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Prepare SQL statement
            String sql = "INSERT INTO user_auth_failure (username, password, fail_count) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Execute the query
            preparedStatement.setString(1, "testUser");
            preparedStatement.setString(2, "testPassword");
            preparedStatement.setInt(3, 0);
            preparedStatement.executeUpdate();

            System.out.println("User successfully authenticated!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}