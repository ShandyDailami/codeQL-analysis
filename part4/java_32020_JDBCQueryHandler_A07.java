import java.sql.*;

public class java_32020_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            authenticateUser(USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Authentication failed. Error: " + e.getMessage());
        }
    }

    private static void authenticateUser(String username, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM Users WHERE username = '" + username + "' AND password = '" + password + "'";
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            System.out.println("User found!");
        } else {
            System.out.println("Authentication failed!");
        }

        connection.close();
    }
}