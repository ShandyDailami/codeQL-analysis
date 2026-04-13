import java.sql.*;

public class java_09724_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM users WHERE role = 'admin'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String role = resultSet.getString("role");
                System.out.println("Role: " + role);
            }
        } catch (SQLException e) {
            System.out.println("Error in connection or query execution: " + e.getMessage());
        }
    }
}