import java.sql.*;

public class java_27329_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL Driver
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "invalidUser"); // Invalid username
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("Authentication failure for user: " + result.getString("username"));
            } else {
                System.out.println("No authentication failure found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}