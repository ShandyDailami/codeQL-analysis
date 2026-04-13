import java.sql.*;

public class java_07059_JDBCQueryHandler_A01 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM Users WHERE username = 'broken' AND password = 'password'";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                System.out.println("User logged in successfully");
            } else {
                System.out.println("Invalid credentials");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}