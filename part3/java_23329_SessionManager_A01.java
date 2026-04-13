import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class java_23329_SessionManager_A01 {
    private List<Connection> availableConnections;
    private List<Connection> usedConnections;
    private String url;
    private String username;
    private String password;

    public java_23329_SessionManager_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.availableConnections = new ArrayList<>();
        this.usedConnections = new ArrayList<>();

        // Register JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (availableConnections.isEmpty()) {
            try {
                Connection conn = DriverManager.getConnection(url, username, password);
                usedConnections.add(conn);
                return conn;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            return availableConnections.remove(availableConnections.size() - 1);
        }
        return null;
    }

    public void returnConnection(Connection conn) {
        if (!usedConnections.contains(conn)) {
            // This should not happen, as we only use connections returned from this method
            throw new IllegalArgumentException("Tried to return connection that wasn't used by this SessionManager");
        }
        availableConnections.add(conn);
        usedConnections.remove(conn);
    }
}