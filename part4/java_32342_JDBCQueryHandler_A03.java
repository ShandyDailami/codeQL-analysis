import java.sql.*;

public class java_32342_JDBCQueryHandler_A03 {
    // Assume we have a database with a table named 'users' and a column named 'password'
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Assume we have a known user
        String knownUser = "someone@example.com";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "SELECT * FROM users WHERE email = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, knownUser);

                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        String password = result.getString("password");
                        // Do something with the password, like check it against a hashed value
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}