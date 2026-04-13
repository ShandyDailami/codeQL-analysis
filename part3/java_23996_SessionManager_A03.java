import java.util.HashMap;
import java.util.Map;

public class java_23996_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_23996_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with id: " + sessionId);
        } else {
            sessionMap.put(sessionId, sessionData);
            System.out.println("Session created successfully with id: " + sessionId);
        }
    }

    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session not found with id: " + sessionId);
            return null;
        }
    }

    public void updateSession(String sessionId, String newSessionData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newSessionData);
            System.out.println("Session updated successfully with id: " + sessionId);
        } else {
            System.out.println("Session not found with id: " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session deleted successfully with id: " + sessionId);
        } else {
            System.out.println("Session not found with id: " + sessionId);
        }
    }
}