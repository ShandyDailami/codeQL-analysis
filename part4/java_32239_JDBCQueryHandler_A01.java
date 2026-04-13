import java.sql.*;

public class java_32239_JDBCQueryHandler_A01 {
    private static Connection conn;
    private static Statement stmt;

    private java_32239_JDBCQueryHandler_A01() {
        try {
            conn = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static JDBCQueryHandler getInstance() {
        return new JDBCQueryHandler();
    }

    public ResultSet executeQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean execute(String query) {
        try {
            return stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}