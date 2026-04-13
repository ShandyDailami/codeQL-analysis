import java.sql.*;

public class java_22922_JDBCQueryHandler_A03 {

    private Connection conn = null;

    public java_22922_JDBCQueryHandler_A03(String url, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, user, password);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");
            ResultSet rs = handler.executeQuery("SELECT * FROM Users WHERE Email = ?");

            while (rs.next()) {
                System.out.println(rs.getString("Email"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}