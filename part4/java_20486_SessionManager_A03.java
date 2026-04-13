import java.util.HashMap;

public class java_20486_SessionManager_A03 {
    private HashMap<String, Session> sessionMap;

    public java_20486_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(Session session) {
        String identifier = session.getId();
        sessionMap.put(identifier, session);
        return identifier;
    }

    public Session getSession(String identifier) {
        return sessionMap.get(identifier);
    }

    public void deleteSession(String identifier) {
        sessionMap.remove(identifier);
    }
}