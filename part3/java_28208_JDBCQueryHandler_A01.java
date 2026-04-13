import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_28208_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_28208_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Open a connection
            conn = DriverManager.getConnection(url, username, password);
            // Create a statement
            stmt = conn.createStatement();
            // Execute the query
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error in JDBCQueryHandler: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error in JDBCQueryHandler closing connections: " + e.getMessage());
            }
        }
        return rs;
    }
}