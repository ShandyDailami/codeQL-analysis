import java.sql.*;

public class java_19843_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            login("user", "password");
        } catch (SQLException e) {
            System.out.println("Failed to login: " + e.getMessage());
        }

        try {
            retrieveUserInfo();
        } catch (SQLException e) {
            System.out.println("Failed to retrieve user info: " + e.getMessage());
        }
    }

    private static void login(String username, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?");
        statement.setString(1, username);

        ResultSet result = statement.executeQuery();

        if (result.next()) {
            System.out.println("Access granted to user " + username);
        } else {
            throw new SQLException("Invalid username or password");
        }
    }

    private static void retrieveUserInfo() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM Users");

        while (result.next()) {
            System.out.println("User info: " + result.getString("username") + ", " + result.getString("email"));
        }
    }
}