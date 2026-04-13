import java.sql.*;

public class java_01010_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_01010_JDBCQueryHandler_A07(String url, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, user, password);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public void executeUpdate(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    public void close() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("url", "user", "password");
            ResultSet rs = handler.executeQuery("SELECT * FROM users WHERE username = 'user' AND password = 'password'");

            while (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));
            }

            handler.close();
        } catch (SQLException e) {
            System.out.println("Error in JDBCQueryHandler: " + e.getMessage());
        }
    }
}