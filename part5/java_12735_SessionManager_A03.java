import java.util.HashMap;

public class java_12735_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_12735_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "Active");
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public String getSessionStatus(String userId) {
        return sessionMap.get(userId);
    }

    public boolean isSessionActive(String userId) {
        return sessionMap.containsKey(userId) && sessionMap.get(userId).equals("Active");
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    public void updateSession(String userId, String sessionStatus) {
        sessionMap.replace(userId, sessionStatus);
    }
}