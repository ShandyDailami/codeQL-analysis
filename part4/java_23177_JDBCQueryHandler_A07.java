import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_23177_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Realistic operation here
            // Let's say we want to select a user's password from a database
            String sql = "SELECT password FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "user1");

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String password = resultSet.getString("password");
                System.out.println("Password: " + password);
            } else {
                System.out.println("No user with the given username found");
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in connection or SQL execution: " + e.getMessage());
        }
    }
}