import java.sql.*;

public class java_35363_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String username = "user1"; // replace with the actual username
            String password = "password1"; // replace with the actual password

            String sql = "SELECT name FROM users WHERE username = '" + username + "' AND password = '" + password + "'";

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                System.out.println("User name: " + resultSet.getString("name"));
            } else {
                System.out.println("Invalid username or password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}