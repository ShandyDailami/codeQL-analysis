import java.util.HashMap;

public class java_18863_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_18863_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public void startSession(String userId) {
        // Here we could check if the user is already logged in and reject the session
        // But for the sake of simplicity, let's just store the userId in the session map
        sessionMap.put(userId, userId);
    }

    // Method to end a session
    public void endSession(String userId) {
        // Here we need to check if the session is valid and the user is the owner of the session
        // But for the sake of simplicity, let's just remove the userId from the session map
        sessionMap.remove(userId);
    }

    // Method to get the userId of the current session
    public String getCurrentUserId(String sessionId) {
        // Here we need to check if the session is valid
        // But for the sake of simplicity, let's just check if the session map contains the sessionId
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }
}