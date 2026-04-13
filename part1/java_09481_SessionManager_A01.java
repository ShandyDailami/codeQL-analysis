import java.util.HashMap;
import java.util.Map;

public class java_09481_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_09481_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String user) {
        sessionMap.put(sessionId, user);
    }

    public String getUserBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void forceEndAllSessions() {
        sessionMap.clear();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Starting a session
        sessionManager.startSession("session1", "User1");
        System.out.println("Session started: " + sessionManager.isSessionActive("session1"));

        // Getting the user from a session
        String user = sessionManager.getUserBySessionId("session1");
        System.out.println("User from session: " + user);

        // Ending a session
        sessionManager.endSession("session1");
        System.out.println("Session ended: " + sessionManager.isSessionActive("session1"));

        // Forcing ending of all sessions
        sessionManager.forceEndAllSessions();
        System.out.println("All sessions ended: " + sessionManager.isSessionActive("session1"));
    }
}