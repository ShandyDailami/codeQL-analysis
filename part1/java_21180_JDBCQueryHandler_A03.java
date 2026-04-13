import java.sql.*;

public class java_21180_JDBCQueryHandler_A03 {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    private final String url = "jdbc:mysql://localhost:3306/test";
    private final String username = "root";
    private final String password = "password";

    public void connect() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}