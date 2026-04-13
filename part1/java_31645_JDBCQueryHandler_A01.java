import java.sql.*;

public class java_31645_JDBCQueryHandler_A01 {
    private Connection conn;
    private Statement stmt;

    public java_31645_JDBCQueryHandler_A01(String dbURL, String dbUser, String dbPass) throws SQLException {
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
        stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }

    public static void main(String[] args) {
        // You should not do this in a production environment. It is only for demo.
        try {
            JDBCQueryHandler jdbc = new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password");
            ResultSet rs = jdbc.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
            jdbc.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}