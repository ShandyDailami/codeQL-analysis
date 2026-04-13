import java.sql.*;

public class java_11550_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT password FROM your_table";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String passwordColumn = resultSet.getString(1);
                // You can now verify the password here. If it's expired, you'll have to do it.
                // However, for simplicity, we'll just print a message.
                System.out.println("Password is expired: " + passwordColumn);
            } else {
                System.out.println("No password found in the table");
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
        }
    }
}