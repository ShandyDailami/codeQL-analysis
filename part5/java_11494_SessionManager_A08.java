import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_11494_SessionManager_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testDB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}