import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_03898_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Get a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare SQL query
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Step 4: Set parameters
            statement.setString(1, "user1");
            statement.setString(2, "password1");

            // Step 5: Execute query
            statement.executeUpdate();

            // Step 6: Close connection
            statement.close();
            connection.close();

            System.out.println("Insertion successful!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}