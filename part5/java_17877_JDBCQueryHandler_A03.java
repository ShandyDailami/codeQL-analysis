import java.sql.*;

public class java_17877_JDBCQueryHandler_A03 {

    // Injectable parameters
    private String dbUrl;
    private String user;
    private String password;

    public java_17877_JDBCQueryHandler_A03(String dbUrl, String user, String password) {
        this.dbUrl = dbUrl;
        this.user = user;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        Connection conn = null;
        ResultSet rs = null;
        try {
            // Create a connection
            conn = DriverManager.getConnection(dbUrl, user, password);
            // Create a statement
            Statement stmt = conn.createStatement();
            // Execute the query
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
}