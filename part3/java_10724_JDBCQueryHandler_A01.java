import java.sql.*;

public class java_10724_JDBCQueryHandler_A01 {
    private Connection conn = null;

    public java_10724_JDBCQueryHandler_A01(String dbURL, String userName, String password) {
        try {
            conn = DriverManager.getConnection(dbURL, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

    public void executeUpdate(String query) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
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
    }
}