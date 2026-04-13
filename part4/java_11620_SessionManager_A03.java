import java.util.HashMap;
import java.util.Map;

public class java_11620_SessionManager_A03 {
    private Map<String, UserSession> sessions;

    public java_11620_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public void startSession(String username) {
        UserSession session = new UserSession();
        session.username = username;
        sessions.put(username, session);
    }

    public void endSession(String username) {
        sessions.remove(username);
    }

    public UserSession getSession(String username) {
        return sessions.get(username);
    }

    private class UserSession {
        public String username;
    }
}