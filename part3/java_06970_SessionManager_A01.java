import java.util.HashMap;
import java.util.Map;

public class java_06970_SessionManager_A01 {
    private String userId;
    private String userName;

    public java_06970_SessionManager_A01(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    // getters and setters
}

public class SessionManager {
    private Map<String, Session> sessions;

    public java_06970_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void addSession(Session session) {
        sessions.put(session.getUserId(), session);
    }

    public Session getSession(String userId) {
        return sessions.get(userId);
    }

    public void removeSession(String userId) {
        sessions.remove(userId);
    }
}