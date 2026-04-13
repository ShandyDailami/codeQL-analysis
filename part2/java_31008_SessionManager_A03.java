import java.util.*;

public class java_31008_SessionManager_A03 {
    private static Map<String, String> sessionMap;

    public java_31008_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new RuntimeException("No session found with id: " + sessionId);
        }
    }

    public void updateSession(String sessionId, String sessionData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, sessionData);
        } else {
            throw new RuntimeException("No session found with id: " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new RuntimeException("No session found with id: " + sessionId);
        }
    }
}