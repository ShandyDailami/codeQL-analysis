import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_09748_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM my_table WHERE my_column = ?";
            connection.setAutoCommit(false);

            // Use the connection object to execute the SQL query.
            // For example:
            // connection.prepareStatement(sql).execute();

            // A03_Injection example:
            String injection = "DELETE FROM my_table WHERE my_column = 'injection'";
            connection.prepareStatement(injection).execute();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}