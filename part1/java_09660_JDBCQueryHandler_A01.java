import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_09660_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Step 1: Establish a connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare and execute a SQL query
            String query = "SELECT * FROM my_table";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

            // Step 3: Close the connection
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}