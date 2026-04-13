import java.util.HashMap;
import java.util.Map;

public class java_36204_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_36204_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public String getSessionValue(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Creating a session
        sessionManager.createSession("session1", "value1");
        sessionManager.createSession("session2", "value2");

        // Getting a session value
        System.out.println("Session1 value: " + sessionManager.getSessionValue("session1"));
        System.out.println("Session2 value: " + sessionManager.getSessionValue("session2"));

        // Updating a session
        sessionManager.updateSession("session1", "new value1");

        // Getting the updated session value
        System.out.println("Updated Session1 value: " + sessionManager.getSessionValue("session1"));

        // Deleting a session
        sessionManager.deleteSession("session1");

        // Checking if session1 is deleted
        System.out.println("Session1 is deleted: " + sessionManager.getSessionValue("session1"));
    }
}