import java.sql.*;

public class java_00769_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            // Access Control Example: Try to select all from a table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Broken Access Control Example: Try to insert a new user
            String insertQuery = "INSERT INTO Users (username, password) VALUES ('newuser', 'newpassword')";
            statement.executeUpdate(insertQuery);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}