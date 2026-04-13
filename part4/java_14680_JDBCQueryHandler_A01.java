import java.sql.*;

public class java_14680_JDBCQueryHandler_A01 {

    private String driverName;
    private String dbURL;
    private String user;
    private String password;

    public java_14680_JDBCQueryHandler_A01(String driverName, String dbURL, String user, String password) {
        this.driverName = driverName;
        this.dbURL = dbURL;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbURL, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(Connection conn, String query) {
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void executeUpdate(Connection conn, String query) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}