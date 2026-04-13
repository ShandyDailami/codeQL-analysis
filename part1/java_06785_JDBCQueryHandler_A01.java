import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_06785_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Step 1: Load JDBC Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish Connection
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 3: Perform Security-Sensitive Operation (Breaking Access Controls)
        try {
            connection.createStatement().execute("DROP TABLE employees");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 4: Disconnect
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}