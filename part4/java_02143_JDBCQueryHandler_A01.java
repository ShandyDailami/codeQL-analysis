import java.sql.*;

public class java_02143_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_02143_JDBCQueryHandler_A01(String dbURL, String user, String password) {
        try {
            conn = DriverManager.getConnection(dbURL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
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
        JDBCQueryHandler jdbc = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "user", "password");
        ResultSet rs = jdbc.executeQuery("SELECT * FROM Users");
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
        jdbc.executeUpdate("DELETE FROM Users WHERE username='admin'");
    }
}