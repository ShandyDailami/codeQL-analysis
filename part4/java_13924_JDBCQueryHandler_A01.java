import java.sql.*;

public class java_13924_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            insertUser("TestUser", "testpassword");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertUser(String username, String password) throws SQLException {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            statement.executeUpdate();

            System.out.println("User inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to insert user: " + e.getMessage());
        }
    }
}