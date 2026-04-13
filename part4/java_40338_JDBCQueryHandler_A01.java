import java.sql.*;

public class java_40338_JDBCQueryHandler_A01 {

    private Connection conn;

    public java_40338_JDBCQueryHandler_A01(String url, String username, String password) {
        try {
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
        ResultSet rs = handler.executeQuery("SELECT * FROM Users");
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
        handler.executeUpdate("UPDATE Users SET password = 'newpassword' WHERE username = 'admin'");
    }
}