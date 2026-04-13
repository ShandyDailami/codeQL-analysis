import java.util.HashMap;

public class java_34282_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_34282_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}