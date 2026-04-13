import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_36034_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Perform authentication-related operation here

            // Here, we are just closing the connection
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Always close the connection
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