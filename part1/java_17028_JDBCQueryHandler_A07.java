import java.sql.*;

public class java_17028_JDBCQueryHandler_A07 {
    // private fields
    private String url;
    private String username;
    private String password;

    // constructor
    public java_17028_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // method to execute a query
    public ResultSet executeQuery(String query) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // establish connection
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error in executing query: " + e.getMessage());
        } finally {
            // close connection
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

        return rs;
    }
}