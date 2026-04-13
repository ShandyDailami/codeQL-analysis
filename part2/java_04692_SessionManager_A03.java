import java.util.HashMap;
import java.util.Map;

public class java_04692_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_04692_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, "Active");
    }

    public void endSession(String sessionId) {
        sessionMap.put(sessionId, "Inactive");
    }

    public String getSessionStatus(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        String status = sessionMap.get(sessionId);
        return (status != null && status.equals("Active"));
    }
}