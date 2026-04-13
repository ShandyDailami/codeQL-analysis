import java.sql.*;

public class java_29532_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM Users WHERE username = ?";
            ResultSet resultSet = statement.executeQuery(sql, "testUser");

            if (resultSet.next()) {
                String passwordFromDB = resultSet.getString("password");
                if (BCrypt.checkpw("testPassword", passwordFromDB)) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Wrong password!");
                }
            } else {
                System.out.println("User not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}