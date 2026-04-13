import java.sql.*;

public class java_15424_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_15424_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public void executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        rs.close();
        stmt.close();
    }

    public void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
            handler.executeQuery("SELECT * FROM users");
            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}