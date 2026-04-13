import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_22560_JDBCQueryHandler_A07 {

    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "myuser";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare the SQL statement
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Step 4: Set parameters for SQL injection
            statement.setString(1, "myuser");
            statement.setString(2, "mypassword");

            // Step 5: Execute the SQL statement
            ResultSet result = statement.executeQuery();

            // Step 6: Process the ResultSet
            while (result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            // Step 7: Clean up
            result.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}