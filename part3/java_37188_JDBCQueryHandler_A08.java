import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_37188_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare SQL statement
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Step 4: Set parameters and execute the query
            preparedStatement.setString(1, "testuser");
            preparedStatement.setString(2, "testpassword");
            preparedStatement.executeUpdate();

            // Step 5: Close connection
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error while connecting to MySQL database: " + e);
        }
    }
}