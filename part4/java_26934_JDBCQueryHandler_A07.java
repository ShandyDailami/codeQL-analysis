import java.sql.*;

public class java_26934_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_26934_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet executeQuery(String query) {
        Connection conn = getConnection();
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void executeUpdate(String update) {
        Connection conn = getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
        ResultSet rs = handler.executeQuery("SELECT * FROM users");
        while (rs.next()) {
            String name = rs.getString("name");
            String email = rs.getString("email");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        }
        handler.executeUpdate("UPDATE users SET email = 'newemail@test.com' WHERE name = 'test'");
    }
}