import java.sql.*;

public class java_24595_SessionManager_A01 {
    private Connection conn;
    private Statement stmt;

    public java_24595_SessionManager_A01() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "user", "password");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}