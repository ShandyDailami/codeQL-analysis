import java.util.HashMap;

public class java_27121_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_27121_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, userId);
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public boolean isValidUser(String userId, String password) {
        String existingUserId = sessionMap.get(userId);
        if (existingUserId == null) {
            return false;
        } else if (!existingUserId.equals(password)) {
            return false;
        }
        return true;
    }

    public boolean isValidSession(String userId, String sessionId) {
        String existingSessionId = sessionMap.get(sessionId);
        if (existingSessionId == null) {
            return false;
        } else if (!existingSessionId.equals(userId)) {
            return false;
        }
        return true;
    }
}