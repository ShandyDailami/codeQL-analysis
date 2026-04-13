import java.sql.*;

public class java_30959_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";
    private static final String SELECT_PASSWORD_SQL = "SELECT password FROM Users WHERE username = ?";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String username = "test_user"; // Replace with actual username

            // Step 1: Prepare statement
            PreparedStatement statement = connection.prepareStatement(SELECT_PASSWORD_SQL);
            statement.setString(1, username);

            // Step 2: Execute statement
            ResultSet result = statement.executeQuery();

            // Step 3: Extract password
            if (result.next()) {
                String password = result.getString("password");
                if (password.equals("A01_BrokenAccessControl")) {
                    System.out.println("Access granted!");
                } else {
                    System.out.println("Access denied!");
                }
            } else {
                System.out.println("No user with the provided username found.");
            }

            // Step 4: Close connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}