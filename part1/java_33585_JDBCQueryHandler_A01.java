import java.sql.*;

public class java_33585_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM users WHERE role='admin'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                System.out.println("Username: " + username);
                System.out.println("Role: " + role);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}