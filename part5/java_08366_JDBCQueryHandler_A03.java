import java.sql.*;

public class java_08366_JDBCQueryHandler_A03 {
    private Connection conn = null;

    public void connect(String dbUrl, String dbUsername, String dbPassword) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Assume MySQL JDBC driver
            conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}