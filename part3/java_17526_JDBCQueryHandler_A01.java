import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_17526_JDBCQueryHandler_A01 {
    // URL of database
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    // Username and password
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create connection
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            // Create a statement
            Statement statement = connection.createStatement();
            // Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE password = 'password'");
            // Process result set
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                System.out.println("Username: " + username);
            }
            // Close connection and statement
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}