import java.sql.*;

public class java_12882_JDBCQueryHandler_A03 {
    private Connection conn = null;

    public java_12882_JDBCQueryHandler_A03(String dbUrl, String username, String password) {
        try {
            // Loading Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Opening Connection
            conn = DriverManager.getConnection(dbUrl, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query, String... params) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Prepare Statement
            pstmt = conn.prepareStatement(query);

            // Bind parameters
            for (int i = 0; i < params.length; i++) {
                pstmt.setString(i + 1, params[i]);
            }

            // Execute Query
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public int executeUpdate(String query, String... params) {
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            // Prepare Statement
            pstmt = conn.prepareStatement(query);

            // Bind parameters
            for (int i = 0; i < params.length; i++) {
                pstmt.setString(i + 1, params[i]);
            }

            // Execute Update
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}