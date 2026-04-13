import java.sql.*;

public class java_18728_JDBCQueryHandler_A07 {
    private Connection conn;

    // constructor
    public java_18728_JDBCQueryHandler_A07(String url, String username, String password) {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // method to execute SELECT queries
    public ResultSet executeQuery(String query) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // method to execute INSERT, UPDATE, DELETE queries
    public int executeUpdate(String query) {
        Statement stmt = null;
        int rows = 0;
        try {
            stmt = conn.createStatement();
            rows = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    // method to close the connection
    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // main method to test the JDBCQueryHandler class
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password");
        ResultSet rs = handler.executeQuery("SELECT * FROM Users");
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
        handler.close();
    }
}