import java.sql.*;

public class java_13477_JDBCQueryHandler_A07 {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                String query = "SELECT * FROM Users WHERE username = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, "testUser");
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    String password = result.getString("password");
                    // Use password for any security-sensitive operations
                    System.out.println("Password: " + password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
        }
        return connection;
    }
}