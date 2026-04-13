import java.sql.*;

public class java_19268_JDBCQueryHandler_A03 {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    // Constructor
    public java_19268_JDBCQueryHandler_A03(String url, String username, String password) {
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute SELECT queries
    public void executeSelect(String query) {
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute INSERT, UPDATE, DELETE queries
    public void executeQuery(String query) {
        try {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to close the connection
    public void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("url", "username", "password");
        handler.executeSelect("SELECT * FROM table");
        handler.closeConnection();
    }
}