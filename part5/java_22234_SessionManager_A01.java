import java.util.HashMap;

public class java_22234_SessionManager_A01 {
    private HashMap<String, Session> sessions;

    public java_22234_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Session with ID " + sessionId + " already exists.");
        } else {
            sessions.put(sessionId, new Session(sessionId));
            System.out.println("Session with ID " + sessionId + " has been started.");
        }
    }

    public void endSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            System.out.println("Session with ID " + sessionId + " has been ended.");
        } else {
            System.out.println("No session with ID " + sessionId + " exists.");
        }
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            System.out.println("No session with ID " + sessionId + " exists.");
            return null;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1");
        sessionManager.startSession("session2");

        sessionManager.endSession("session1");
        sessionManager.startSession("session1");

        sessionManager.getSession("session2");
    }
}

class Session {
    private String sessionId;

    public java_22234_SessionManager_A01(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}