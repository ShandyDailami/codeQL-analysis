import java.sql.*;

public class java_02418_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String sql = "SELECT password_hash FROM users WHERE username = ?";
            ResultSet resultSet = statement.executeQuery(sql, "user"); // replace "user" with the actual username

            if (resultSet.next()) {
                String passwordHash = resultSet.getString("password_hash");
                System.out.println("Password hash: " + passwordHash);
            } else {
                System.out.println("No user found with the username 'user'");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}