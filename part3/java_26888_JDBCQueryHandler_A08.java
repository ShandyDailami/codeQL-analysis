import java.sql.*;

public class java_26888_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            checkUserExistsAndPasswordIsStrong();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void checkUserExistsAndPasswordIsStrong() throws SQLException {
        String query = "SELECT * FROM users WHERE username = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "user1"); // replace with actual user
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String password = resultSet.getString("password");
                if (isPasswordStrong(password)) {
                    System.out.println("User exists and password is strong.");
                } else {
                    System.out.println("User exists but password is not strong.");
                }
            } else {
                System.out.println("User does not exist.");
            }
        }
    }

    private static boolean isPasswordStrong(String password) {
        // Here you should implement logic to check if the password is strong
        // This can involve checking if it has a minimum length, a mix of upper and lower case letters,
        // a mix of numbers and special characters, etc.

        return password.length() >= 8;
    }
}