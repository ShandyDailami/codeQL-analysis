import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_03362_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        try {
            // Step 1: Load database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");

            // Step 3: Execute SQL query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE role = 'Admin'");

            // Step 4: Handle the ResultSet
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                System.out.println("Username: " + username);
                System.out.println("Role: " + role);
            }

            // Step 5: Close database connection
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}