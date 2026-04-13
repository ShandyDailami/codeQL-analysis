import java.sql.*;

public class java_36655_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            // Broken access control A01: Direct database access
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = 'admin'");

            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Password: " + resultSet.getString("password"));
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in connection: " + e.getMessage());
        }
    }
}