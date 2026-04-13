import java.util.HashMap;

public class java_05942_SessionManager_A07 {
    private HashMap<String, String> sessionMap; // use a HashMap to simulate a database

    public java_05942_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = java.util.UUID.randomUUID().toString(); // generate a random session id
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to retrieve the user id from a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}