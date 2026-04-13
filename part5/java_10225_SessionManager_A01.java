import java.util.*;

public class java_10225_SessionManager_A01 {
    private List<Session> sessions;
    private Map<String, Session> sessionMap;

    public java_10225_SessionManager_A01() {
        sessions = new ArrayList<>();
        sessionMap = new HashMap<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
        sessionMap.put(session.getUser(), session);
    }

    public Session getSession(String user) {
        return sessionMap.get(user);
    }

    public void removeSession(Session session) {
        sessions.remove(session);
        sessionMap.remove(session.getUser());
    }
}