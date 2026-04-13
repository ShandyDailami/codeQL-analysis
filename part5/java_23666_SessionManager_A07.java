import java.util.HashMap;
import java.util.Map;

public class java_23666_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_23666_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Session " + sessionId + " already exists.");
            return sessions.get(sessionId);
        } else {
            System.out.println("Creating a new session " + sessionId + ".");
            Session newSession = new Session(sessionId);
            sessions.put(sessionId, newSession);
            return newSession;
        }
    }

    public void closeSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Closing session " + sessionId + ".");
            sessions.get(sessionId).close();
            sessions.remove(sessionId);
        } else {
            System.out.println("No session " + sessionId + " found.");
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.getSession("session1");
        sm.getSession("session1");  // Should print "Session session1 already exists."

        sm.getSession("session2");  // Should print "Creating a new session session2."
        sm.closeSession("session1");  // Should print "Closing session session1."
        sm.closeSession("session3");  // Should print "No session session3 found."
    }
}