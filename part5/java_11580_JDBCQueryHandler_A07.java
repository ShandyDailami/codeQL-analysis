import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_11580_JDBCQueryHandler_A07 {
    // JDBC driver name and database URL
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "myusername";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName(driver);

            // Step 2: Open a connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Perform SQL query
            String sql = "SELECT * FROM mytable";
            conn.createStatement().executeQuery(sql);

            System.out.println("Connected to the database successfully!");

        } catch (Exception e) {
            System.out.println("Error while connecting to the database!");
            e.printStackTrace();
        } finally {
            // Step 4: Close the connection
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