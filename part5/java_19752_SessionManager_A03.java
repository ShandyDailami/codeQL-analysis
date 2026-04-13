import java.util.HashMap;

public class java_19752_SessionManager_A03 {
    // Define a HashMap to store sessions.
    private HashMap<String, String> sessionMap;

    // Constructor.
    public java_19752_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String userName) {
        String sessionId = userName + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    // Method to get the user name from the session.
    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to validate the session.
    public boolean validateSession(String sessionId) {
        // This is a simple validation, we can add more complex logic here.
        // For example, we can check if the sessionId is in the sessionMap and if the user is still logged in.
        return sessionMap.containsKey(sessionId);
    }

    // Method to invalidate the session.
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}