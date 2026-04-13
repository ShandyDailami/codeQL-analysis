import java.sql.*;

public class java_35659_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:your_db_url";
    private static final String USER = "your_user";
    private static final String PASS = "your_password";

    public static void main(String[] args) {
        try {
            authenticateUser();
        } catch (SQLException e) {
            System.out.println("An error occurred while trying to authenticate: " + e.getMessage());
        }
    }

    private static void authenticateUser() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            System.out.println("User authenticated successfully");
        } else {
            throw new SQLException("Authentication failure");
        }

        connection.close();
    }
}