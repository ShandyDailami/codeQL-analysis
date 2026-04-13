import java.sql.*;

public class java_33846_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                String query = "SELECT * FROM users WHERE username = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, "testUser");
                ResultSet result = statement.executeQuery();
                if (result.next()) {
                    // Security-sensitive operation related to A08_IntegrityFailure
                    if (result.getString("password").equals("securePassword")) {
                        System.out.println("Access granted!");
                    } else {
                        System.out.println("Access denied!");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}