import java.sql.*;

public class java_37955_JDBCQueryHandler_A01 {
    // Step 1: Define a method to connect to the database
    public Connection connect(String dbURL, String username, String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Step 2: Define a method to execute a query
    public ResultSet executeQuery(Connection conn, String query) {
        ResultSet resultSet = null;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(query);
            resultSet = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Step 3: Define a method to close connections
    public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}