import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_19879_JDBCQueryHandler_A07 {

    // Define our database credentials
    private static final String DB_USERNAME = "db_username";
    private static final String DB_PASSWORD = "db_password";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test_database";

    public static void main(String[] args) {
        Connection conn = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Execute a query
            String query = "SELECT * FROM test_table";
            conn.createStatement().execute(query);

            // Process the result set
            // ...

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Ensure we close our database connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}