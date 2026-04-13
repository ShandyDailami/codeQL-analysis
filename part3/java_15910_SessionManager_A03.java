import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class java_15910_SessionManager_A03 {
    private Map<String, Connection> connections;

    public java_15910_SessionManager_A03() {
        connections = new HashMap<>();
    }

    public Connection getConnection(String username) {
        Connection conn = connections.get(username);
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
                connections.put(username, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public void closeConnection(String username) {
        Connection conn = connections.get(username);
        if (conn != null) {
            try {
                conn.close();
                connections.remove(username);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}