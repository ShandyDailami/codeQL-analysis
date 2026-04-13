import java.sql.*;
import java.util.HashMap;

public class java_07763_SessionManager_A03 {
    private HashMap<String, String> sessions = new HashMap<>();
    private Connection conn;

    public java_07763_SessionManager_A03(String dbUrl, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(dbUrl, username, password);
    }

    public String createSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE id = " + sessionId);
                if (rs.next()) {
                    sessions.put(sessionId, rs.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessions.getOrDefault(sessionId, null);
    }

    public void closeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}