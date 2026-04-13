import java.util.HashMap;
import java.util.Map;

public class java_20691_SessionManager_A01 implements ISessionManager {
    private Map<String, Session> sessions;

    public java_20691_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    @Override
    public void addSession(Session session) {
        sessions.put(session.getUsername(), session);
    }

    @Override
    public void removeSession(String username) {
        sessions.remove(username);
    }

    @Override
    public Session getSession(String username) {
        return sessions.get(username);
    }

    @Override
    public boolean isValidSession(String username, String password) {
        Session session = getSession(username);
        return session != null && session.getPassword().equals(password);
    }
}