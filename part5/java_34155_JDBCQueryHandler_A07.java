import java.sql.*;

public class java_34155_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            authenticateUser("invalid_user", "invalid_password");
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }

    public static void authenticateUser(String username, String password) throws AuthenticationException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();

            String sql = "SELECT * FROM users WHERE username = '" + username + "'";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                if (password.equals(dbPassword)) {
                    System.out.println("Authentication successful!");
                } else {
                    throw new AuthenticationException("Wrong password!");
                }
            } else {
                throw new AuthenticationException("User not found!");
            }
        } catch (SQLException e) {
            throw new AuthenticationException("Failed to authenticate user. " + e.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // Do nothing
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // Do nothing
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Do nothing
                }
            }
        }
    }

    static class AuthenticationException extends Exception {
        public java_34155_JDBCQueryHandler_A07(String message) {
            super(message);
        }
    }
}