import java.sql.*;

public class java_05237_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Starts a connection
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Execute a statement
            String sql = "SELECT * FROM employees WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, 101); // Set the parameter value

                // Execute the statement
                ResultSet resultSet = statement.executeQuery();

                // Process the result set
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    System.out.println("id: " + id + ", name: " + name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}