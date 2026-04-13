import java.sql.*;

public class java_33949_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM users WHERE email = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "test@example.com"); // This is a parameterized query, but the actual value is not used in this example.

                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    System.out.println(result.getString("name"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}