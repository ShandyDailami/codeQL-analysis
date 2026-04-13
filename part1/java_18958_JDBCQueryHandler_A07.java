import java.sql.*;

public class java_18958_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            authenticate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void authenticate() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();

        // Assume we have a query to check user credentials
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + USER + "' AND password = '" + PASSWORD + "'");

        if (resultSet.next()) {
            System.out.println("Authenticated successfully");
        } else {
            throw new SQLException("Authentication failed");
        }

        connection.close();
    }
}