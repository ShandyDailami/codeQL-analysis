import java.sql.*;

public class java_01774_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "testUser"); // Assume user is trying to access 'testUser'

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("No user found.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while executing SQL query: " + e.getMessage());
        }
    }
}