import java.util.HashMap;
import java.util.Map;

public class java_28195_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_28195_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, String newData) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newData);
        } else {
            System.out.println("Session not found");
        }
    }

    public void deleteSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("Session not found");
        }
    }
}