import java.util.HashMap;
import java.util.Map;

public class java_31523_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_31523_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists. ID: " + sessionId);
        } else {
            sessionMap.put(sessionId, sessionData);
            System.out.println("Created new session. ID: " + sessionId + ", Data: " + sessionData);
        }
    }

    public void retrieveSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session data for ID: " + sessionId + ", Data: " + sessionMap.get(sessionId));
        } else {
            System.out.println("No session exists with ID: " + sessionId);
        }
    }

    public void updateSession(String sessionId, String newData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newData);
            System.out.println("Updated session data for ID: " + sessionId + ", New Data: " + newData);
        } else {
            System.out.println("No session exists with ID: " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Deleted session. ID: " + sessionId);
        } else {
            System.out.println("No session exists with ID: " + sessionId);
        }
    }
}