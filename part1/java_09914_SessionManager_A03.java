import java.util.HashMap;
import java.util.Map;

public class java_09914_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_09914_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSessionValue(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSessionValue(String sessionId, String newValue) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newValue);
        } else {
            System.out.println("Session not found!");
        }
    }

    public void deleteSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("Session not found!");
        }
    }
}