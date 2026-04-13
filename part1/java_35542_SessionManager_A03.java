import java.util.HashMap;

public class java_35542_SessionManager_A03 {

    private HashMap<String, String> sessionMap;

    public java_35542_SessionManager_A03() {
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
}