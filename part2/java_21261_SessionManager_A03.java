import java.util.Hashtable;
import java.util.Iterator;

public class java_21261_SessionManager_A03 {
    private Hashtable<String, Session> sessionTable;

    public java_21261_SessionManager_A03() {
        sessionTable = new Hashtable<>();
    }

    public String createSession(Session session) {
        String sessionId = session.getId();
        sessionTable.put(sessionId, session);
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessionTable.get(sessionId);
    }

    public void updateSession(Session session) {
        String sessionId = session.getId();
        sessionTable.replace(sessionId, session);
    }

    public void deleteSession(String sessionId) {
        sessionTable.remove(sessionId);
    }

    public Iterator<Session> getAllSessions() {
        return sessionTable.values().iterator();
    }
}