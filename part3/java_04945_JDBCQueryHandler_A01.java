import java.sql.*;

public class java_04945_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return null;
    }

    public int executeUpdate(String query) throws SQLException {
        Connection conn = null;
        int rowsUpdated = 0;

        try {
            conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            rowsUpdated = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

        return rowsUpdated;
    }
}