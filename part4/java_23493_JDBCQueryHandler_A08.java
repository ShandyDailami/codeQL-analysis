import java.sql.*;

public class java_23493_JDBCQueryHandler_A08 {

    private Connection conn;

    // Establish a connection with the database
    public java_23493_JDBCQueryHandler_A08(String url, String username, String password) {
        try {
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Execute a SELECT query
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

    // Execute an UPDATE, INSERT, or DELETE query
    public int executeUpdate(String query) {
        try {
            Statement stmt = this.conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Close the connection
    public void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}