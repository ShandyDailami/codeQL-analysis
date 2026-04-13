import java.util.HashMap;

public class java_29041_SessionManager_A08 {

    private HashMap<String, Session> sessionMap;

    public java_29041_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, Session session) {
        if (session == null) {
            System.out.println("Session is null. Cannot add session with ID: " + sessionId);
            return;
        }

        if (sessionId == null || sessionId.equals("")) {
            System.out.println("Session ID is null or empty. Cannot add session with ID: " + sessionId);
            return;
        }

        sessionMap.put(sessionId, session);
    }

    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            System.out.println("Session ID is null or empty.");
            return null;
        }

        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            System.out.println("Session ID is null or empty. Cannot remove session with ID: " + sessionId);
            return;
        }

        Session session = sessionMap.get(sessionId);
        if (session == null) {
            System.out.println("Session with ID: " + sessionId + " not found. Cannot remove session.");
            return;
        }

        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.addSession("session1", new Session());
        sessionManager.addSession("session2", new Session());
        sessionManager.addSession("session3", null);

        sessionManager.getSession("session1");
        sessionManager.getSession("session2");
        sessionManager.getSession("session3");

        sessionManager.removeSession("session1");
        sessionManager.removeSession("session2");
        sessionManager.removeSession("session3");
        sessionManager.removeSession(null);
    }
}