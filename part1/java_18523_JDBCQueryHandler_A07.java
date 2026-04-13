import java.sql.*;

public class java_18523_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_18523_JDBCQueryHandler_A07(String dbURL, String user, String password) {
        try {
            conn = DriverManager.getConnection(dbURL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");
        ResultSet rs = handler.executeQuery("SELECT * FROM users");
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
        handler.executeUpdate("UPDATE users SET password='newpass' WHERE username='user'");
    }
}