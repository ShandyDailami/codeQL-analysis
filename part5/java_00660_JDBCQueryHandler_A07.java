import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_00660_JDBCQueryHandler_A07 {

    // This is a dummy method, it is used to get a connection
    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
        } catch (SQLException e) {
            System.out.println("Error while trying to get connection");
        }
        return conn;
    }

    // This is a dummy method, it is used to close a connection
    private void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error while trying to close connection");
        }
    }

    // This is the main method that handles the database operations
    public void handleQuery(String query) {
        Connection conn = getConnection();
        if (conn != null) {
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                pstmt = conn.prepareStatement(query);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    System.out.println("User ID: " + rs.getString("id"));
                    System.out.println("User Name: " + rs.getString("username"));
                }
            } catch (SQLException e) {
                System.out.println("Error while trying to execute query");
            } finally {
                closeConnection(conn);
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.handleQuery("SELECT id, username FROM users WHERE id = ?");
    }
}