import java.sql.*;

public class java_25961_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                executeQuery(connection);
                executeUpdate(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void executeQuery(Connection connection) throws SQLException {
        String query = "SELECT * FROM users WHERE password = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "testPassword");
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            String username = result.getString("username");
            System.out.println("Username: " + username);
        }
    }

    private static void executeUpdate(Connection connection) throws SQLException {
        String query = "UPDATE users SET password = ? WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "newPassword");
        statement.setString(2, "testUser");
        statement.executeUpdate();
    }
}