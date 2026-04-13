import java.sql.*;

public class java_03906_JDBCQueryHandler_A08 {

    private Connection connection;

    public java_03906_JDBCQueryHandler_A08(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public boolean userExists(int userId) {
        String query = "SELECT * FROM users WHERE id = ?";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query, userId);

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Replace with your own URL, username, and password
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
            boolean exists = handler.userExists(1);
            System.out.println("User exists: " + exists);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}