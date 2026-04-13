import java.sql.*;

public class java_19315_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "testuser");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Add your security-related operations here
            // For example, checking the user's role and granting access if necessary
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}