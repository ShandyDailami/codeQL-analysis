import java.sql.*;

public class java_37920_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, 101); // Assume that there is a user with id 101

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("User name: " + name);
            }

        } catch (SQLException e) {
            System.out.println("Error in handling SQL request: " + e.getMessage());
        }
    }
}