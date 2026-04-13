import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_21003_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Perform some operation with the database
            // Here, we simply select all records from a table named "users"
            String sql = "SELECT * FROM users";
            conn.createStatement().execute(sql);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e);
        } finally {
            // Step 4: Close the connection to the database
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error: " + e);
                }
            }
        }
    }
}