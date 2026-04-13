import java.sql.*;

public class java_05758_JDBCQueryHandler_A07 {
    private Connection conn = null;

    public java_05758_JDBCQueryHandler_A07(String dbURL, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbURL, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");
            ResultSet rs = handler.executeQuery("SELECT * FROM users WHERE role='admin'");

            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}