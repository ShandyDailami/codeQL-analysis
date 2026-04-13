import java.util.HashMap;
import java.util.Map;

public class java_07319_SessionManager_A01 implements SessionContext {
    private Map<String, Session> sessions;

    public java_07319_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    @Override
    public Session createSession(SessionContext context, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            Session session = new SecuritySession(username);
            sessions.put(username, session);
            return session;
        }
        return null;
    }

    @Override
    public Session getSession(SessionContext context, String id) {
        return sessions.get(id);
    }

    @Override
    public void invalidateSession(SessionContext context, String id) {
        sessions.remove(id);
    }

    @Override
    public void putValue(SessionContext context, String s, String s1, Object o) {
        // Implementing security sensitive operations
        // This method is not used in this example
    }

    @Override
    public Object getValue(SessionContext context, String s, String s1) {
        // Implementing security sensitive operations
        // This method is not used in this example
        return null;
    }

    @Override
    public Collection<Session> getAllSessions(SessionContext sessionContext) {
        // Implementing security sensitive operations
        // This method is not used in this example
        return null;
    }
}