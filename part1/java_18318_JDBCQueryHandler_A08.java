import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_18318_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase", "username", "password");

            // Step 3: Create a statement
            Statement statement = connection.createStatement();

            // Step 4: Execute a SQL query
            String sql = "SELECT * FROM mytable WHERE id='1' AND password='mypassword'";
            statement.executeUpdate(sql);

            // Close connection and statement
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}