import java.sql.*;

public class java_41662_JDBCQueryHandler_A01 {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            // Unique operation: Broken Access Control
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = 'broken' AND password = 'broken'");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to database: " + e);
        }
    }
}