import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_12870_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // 1. Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Prepare a statement
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            statement = connection.prepareStatement(sql);

            // 3. Execute the statement
            statement.setString(1, "user1");
            statement.setString(2, "password1");
            statement.executeUpdate();

            // 4. Clean up
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}