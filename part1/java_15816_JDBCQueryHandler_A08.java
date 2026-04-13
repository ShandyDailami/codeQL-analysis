import java.sql.*;

public class java_15816_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String insertQuery = "INSERT INTO Users (name, email) VALUES (?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertQuery);

            // set parameters
            insertStmt.setString(1, "Test User");
            insertStmt.setString(2, "test.user@example.com");

            // execute query
            insertStmt.executeUpdate();

            String selectQuery = "SELECT * FROM Users WHERE name = ?";
            PreparedStatement selectStmt = connection.prepareStatement(selectQuery);

            // set parameter
            selectStmt.setString(1, "Test User");

            ResultSet resultSet = selectStmt.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("Name: " + name + ", Email: " + email);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}