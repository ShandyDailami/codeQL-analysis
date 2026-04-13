import java.util.HashMap;
import java.util.Map;

public class java_24975_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_24975_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSessionData(String sessionId, String newSessionData) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newSessionData);
        } else {
            System.out.println("No such session found!");
        }
    }

    public boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}