import java.sql.*;

public class java_08294_JDBCQueryHandler_A08 {
    // Database credentials
    private static final String DB_USERNAME = "db_username";
    private static final String DB_PASSWORD = "db_password";
    // Database credentials

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Or whatever driver you are using
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name", DB_USERNAME, DB_PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
           .
.
.
                // Handle error here
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        // Example of security-sensitive operation
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql, "admin");
            if (resultSet.next()) {
                System.out.println("User found");
            } else {
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}