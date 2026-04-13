import java.util.HashMap;
import java.util.Map;

public class java_10412_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_10412_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with id: " + sessionId);
        } else {
            sessionMap.put(sessionId, sessionData);
            System.out.println("Session created with id: " + sessionId);
        }
    }

    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session exists with id: " + sessionId);
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session deleted with id: " + sessionId);
        } else {
            System.out.println("No session exists with id: " + sessionId);
        }
    }

    public void updateSessionData(String sessionId, String newSessionData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newSessionData);
            System.out.println("Session data updated with id: " + sessionId);
        } else {
            System.out.println("No session exists with id: " + sessionId);
        }
    }
}