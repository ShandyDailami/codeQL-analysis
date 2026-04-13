import java.sql.*;

public class java_12172_JDBCQueryHandler_A07 {
    // The database URL, username, and password are stored here
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Establish a connection to the database
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            System.out.println("Connected to database!");

            // Assume we want to fetch a user's password from the database
            String SQL = "SELECT password FROM users WHERE username = ?";

            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                statement.setString(1, "testuser"); // Replace with the actual username

                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        String password = result.getString("password");
                        System.out.println("Password: " + password);

                        // Check if the password matches the expected password
                        if (password.equals("expectedpassword")) {
                            System.out.println("Access granted!");
                        } else {
                            System.out.println("Access denied!");
                        }
                    } else {
                        System.out.println("No user found with that username!");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}