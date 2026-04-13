import java.sql.*;

public class java_12751_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_12751_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new AuthFailureException("Authentication failure.", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // Do nothing, we're just closing if we can't
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    // Do nothing, we're just closing if we can't
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // Do nothing, we're just closing if we can't
                }
            }
        }
        return rs;
    }
}

class AuthFailureException extends RuntimeException {
    public java_12751_JDBCQueryHandler_A07(String message, Throwable cause) {
        super(message, cause);
    }
}