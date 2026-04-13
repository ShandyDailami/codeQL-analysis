import java.sql.*;

public class java_04675_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "testUser");
            statement.setString(2, "testPassword");

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}