import java.util.HashMap;
import java.util.Map;

public class java_18789_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_18789_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("session1", "value1");
        sessionManager.createSession("session2", "value2");

        // Get a session
        System.out.println("Session1: " + sessionManager.getSession("session1"));
        System.out.println("Session2: " + sessionManager.getSession("session2"));

        // Delete a session
        sessionManager.deleteSession("session1");

        // Check if a session exists
        System.out.println("Does session1 exist? " + sessionManager.hasSession("session1"));
        System.out.println("Does session3 exist? " + sessionManager.hasSession("session3"));
    }
}