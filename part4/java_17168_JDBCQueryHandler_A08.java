import java.sql.*;

public class java_17168_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_name";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "UPDATE users SET name = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // set the values for the query
            statement.setString(1, "New Name");
            statement.setInt(2, 1);

            // execute the query
            statement.executeUpdate();

            System.out.println("Record updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}