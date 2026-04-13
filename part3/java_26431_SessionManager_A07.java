import java.util.HashMap;
import java.util.Map;

public class java_26431_SessionManager_A07 {

    // The map to store sessions
    private Map<String, String> sessionMap;

    // The map to store user credentials
    private Map<String, String> credentialMap;

    public java_26431_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
        this.credentialMap = new HashMap<>();
    }

    // Function to add a session
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Function to validate a session
    public String validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Function to authenticate a user
    public String authenticateUser(String userId, String password) {
        if (credentialMap.containsKey(userId) && credentialMap.get(userId).equals(password)) {
            return userId;
        } else {
            return null;
        }
    }

    // Function to add a user
    public void addUser(String userId, String password) {
        credentialMap.put(userId, password);
    }

    // Function to check if a user is authenticated
    public boolean isAuthenticated(String userId) {
        return credentialMap.containsKey(userId);
    }

    // Function to check if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Function to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Function to remove a user
    public void removeUser(String userId) {
        sessionMap.remove(userId);
        credentialMap.remove(userId);
    }

}