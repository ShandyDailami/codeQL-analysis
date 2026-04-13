import java.sql.*;

public class java_10609_JDBCQueryHandler_A07 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            authenticateUser(USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to authenticate user: " + e.getMessage());
        }
    }

    private static void authenticateUser(String username, String password) throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            statement = connection.createStatement();

            String sql = "SELECT * FROM Users WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                System.out.println("User authenticated successfully.");
            } else {
                System.out.println("Failed to authenticate user.");
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}