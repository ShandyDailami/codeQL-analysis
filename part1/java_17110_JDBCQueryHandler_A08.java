import java.sql.*;

public class java_17110_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM my_table WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, 123); // set the id you're interested in

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String columnValue = result.getString("my_column");
                // handle the columnValue as required
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}