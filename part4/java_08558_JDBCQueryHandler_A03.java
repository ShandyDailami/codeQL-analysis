import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_08558_JDBCQueryHandler_A03 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Create a query
            String query = "INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);

            // Step 4: Set parameters and execute
            preparedStatement.setInt(1, 100);
            preparedStatement.setString(2, "John Doe");
            preparedStatement.setDouble(3, 70000);
            preparedStatement.executeUpdate();

            // Step 5: Clean up
            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}