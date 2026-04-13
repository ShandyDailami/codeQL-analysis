import java.sql.*;

public class java_28938_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_28938_JDBCQueryHandler_A03(String dbURL, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbURL, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        return stmt.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
            ResultSet rs = handler.executeQuery("SELECT * FROM users WHERE email=?");
            while (rs.next()) {
                System.out.println(rs.getString("email"));
            }
            handler.executeUpdate("UPDATE users SET password=? WHERE email=?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}