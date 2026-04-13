import java.sql.*;

public class java_23038_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, "testUser");

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                // integrity failure here
                System.out.println("Found user");
            } else {
                System.out.println("No user found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}