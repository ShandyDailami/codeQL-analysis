import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_16143_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        // Step 1: Register JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish a connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            // Step 3: Prepare a statement
            String sql = "SELECT * FROM users WHERE role = 'admin'";
            Statement statement = connection.createStatement();

            // Step 4: Execute the query
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 5: Process the result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                System.out.println("Username: " + username);
                System.out.println("Role: " + role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}