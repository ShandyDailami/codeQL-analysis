import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_37699_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare SQL statement
            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            statement = connection.prepareStatement(query);

            // Step 4: Execute SQL statement
            statement.setString(1, "user1");
            statement.setString(2, "password1");
            statement.executeUpdate();

            // Step 5: Clean up
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}