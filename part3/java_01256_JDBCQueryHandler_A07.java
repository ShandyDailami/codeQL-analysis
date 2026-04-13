import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01256_JDBCQueryHandler_A07 {

    public Connection getConnection(String dbURL, String user, String password) throws SQLException {
        Connection conn = DriverManager.getConnection(dbURL, user, password);
        return conn;
    }

    public void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(Connection conn, String query) {
        try {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    // Handle the result set
                }
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        Connection conn = null;
        try {
            conn = handler.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
            handler.executeQuery(conn, "SELECT * FROM users");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            handler.closeConnection(conn);
        }
    }
}