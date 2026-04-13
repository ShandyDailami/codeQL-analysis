import java.sql.*;

public class java_25570_JDBCQueryHandler_A07 {
    private Connection conn = null;

    public void connect(String dbURL, String userName, String password) {
        try {
            this.conn = DriverManager.getConnection(dbURL, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            Statement stmt = this.conn.createStatement();
            int result = stmt.executeUpdate(query);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void closeConnection() {
        try {
            if (this.conn != null && !this.conn.isClosed()) {
                this.conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}