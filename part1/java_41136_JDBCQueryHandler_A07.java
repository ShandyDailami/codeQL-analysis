import java.sql.*;

public class java_41136_JDBCQueryHandler_A07 {
    private Connection conn;
    private Statement stmt;

    // Constructor
    public java_41136_JDBCQueryHandler_A07(String dbUrl, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(dbUrl, user, password);
        stmt = conn.createStatement();
    }

    // Query Execution
    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    // PreparedStatement Execution
    public ResultSet executeQuery(String query, Object[] values) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(query);
        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i + 1, values[i]);
        }
        return pstmt.executeQuery();
    }

    // Authentication Failure
    public boolean isAuthFailure(String query) {
        try {
            executeQuery(query);
            return false; // Authentication successful
        } catch (SQLException e) {
            // Check for specific error
            if (e.getErrorCode() == ConnectionConstants.AUTH_FAILURE) {
                return true; // Authentication failed
            }
        }
        return false; // Other exception or no authentication failure
    }

    // Close Connection
    public void close() throws SQLException {
        stmt.close();
        conn.close();
    }
}