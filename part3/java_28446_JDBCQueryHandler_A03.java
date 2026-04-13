import java.sql.*;

public class java_28446_JDBCQueryHandler_A03 {

    // Step 1: Connect to the database
    private static Connection connectToDatabase() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:your_db_url", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Step 2: Execute a query
    private static void executeQuery(Connection conn, String query) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = connectToDatabase();
        executeQuery(conn, "SELECT * FROM your_table");
    }
}