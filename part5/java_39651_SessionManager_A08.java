import java.util.HashMap;

public class java_39651_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_39651_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Added a method to check if sessionId is valid
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Added a method to check if userId is valid
    public boolean isValidUser(String userId) {
        for (String sessionId : sessionMap.values()) {
            if (sessionId.equals(userId)) {
                return true;
            }
        }
        return false;
    }
}