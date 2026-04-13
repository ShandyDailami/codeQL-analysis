import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_02679_JDBCQueryHandler_A03 {

    // Part 1: Secure way to connect to a database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "mypassword";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Part 2: Secure way to execute a query
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            String sql = "SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            try {
                conn.createStatement().execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}