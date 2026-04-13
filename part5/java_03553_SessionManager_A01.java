import java.util.HashSet;

public class java_03553_SessionManager_A01 {
    private HashSet<String> sessions;

    public java_03553_SessionManager_A01() {
        sessions = new HashSet<>();
    }

    public void addSession(String sessionId) {
        sessions.add(sessionId);
    }

    public void removeSession(String sessionId) throws Exception {
        if (!sessions.remove(sessionId)) {
            throw new Exception("Session not found.");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.addSession("session1");
        sessionManager.addSession("session2");

        try {
            sessionManager.removeSession("session3"); // This will throw an exception
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}