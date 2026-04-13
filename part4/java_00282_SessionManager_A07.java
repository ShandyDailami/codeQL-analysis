import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_00282_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_00282_SessionManager_A07() {
        sessionMap = new ConcurrentHashMap<>();
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
}