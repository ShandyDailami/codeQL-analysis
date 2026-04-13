import java.sql.*;

public class java_41042_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            authenticate();
        } catch (SQLException e) {
            System.out.println("Authentication failed. Please check your credentials.");
        }
    }

    public static void authenticate() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        String query = "SELECT * FROM Users WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "invalid_username"); // This is an invalid username

        ResultSet result = statement.executeQuery();

        if (result.next()) {
            System.out.println("Authentication failed. Invalid password provided.");
        } else {
            System.out.println("Authentication successful.");
        }

        connection.close();
    }
}