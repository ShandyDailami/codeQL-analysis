import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_38291_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare a SQL statement
            String sql = "UPDATE employees SET salary = salary * ? WHERE id = ?";
            statement = connection.prepareStatement(sql);

            // Step 4: Set parameters and execute the query
            statement.setDouble(1, 1.1); // Example multiplier
            statement.setInt(2, 1001); // Example id
            statement.executeUpdate();

            // Step 5: Close the resources
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}