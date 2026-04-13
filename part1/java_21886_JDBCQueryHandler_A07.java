import java.sql.*;

public class java_21886_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            authenticateUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void authenticateUser() throws SQLException {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement statement = connection.prepareStatement(query);

        // Set parameters for query
        statement.setString(1, "user1");
        statement.setString(2, "password1");

        ResultSet result = statement.executeQuery();

        if (result.next()) {
            System.out.println("User authenticated successfully!");
        } else {
            throw new SQLException("Authentication failed.");
        }

        connection.close();
    }
}