import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_12418_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        // Step 1: Establish a Connection
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // Step 2: Perform security-sensitive operations (will fail)
        try {
            connection.createStatement().execute("SELECT * FROM sensitive_table");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 3: Disconnect from the database
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}