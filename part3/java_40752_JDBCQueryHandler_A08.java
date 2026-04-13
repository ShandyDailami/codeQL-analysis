import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_40752_JDBCQueryHandler_A08 {
    // Define the database credentials and URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Establish a connection
    public Connection establishConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Execute a query
    public void executeQuery(String query) {
        Connection conn = establishConnection();
        if (conn != null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}