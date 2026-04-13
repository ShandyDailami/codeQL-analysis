import java.sql.*;

public class java_02918_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection conn;

    public java_02918_JDBCQueryHandler_A01() {
        try {
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt.executeQuery();
    }

    public void executeUpdate(String query) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}