import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class java_06189_SessionManager_A07 {
    private HashMap<String, Connection> sessions = new HashMap<>();

    public Connection getSession(String username) {
        if (sessions.containsKey(username)) {
            return sessions.get(username);
        } else {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
                sessions.put(username, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }
    }

    public void closeSession(String username) {
        if (sessions.containsKey(username)) {
            try {
                sessions.get(username).close();
                sessions.remove(username);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}