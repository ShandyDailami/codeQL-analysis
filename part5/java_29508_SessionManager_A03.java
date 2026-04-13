import java.util.HashMap;
import java.util.Map;

public class java_29508_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_29508_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String newSessionData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newSessionData);
        }
    }

    public void validateSessionId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session with ID: " + sessionId + " is valid");
        } else {
            System.out.println("Session with ID: " + sessionId + " is not valid");
        }
    }
}