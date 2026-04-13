import java.util.HashMap;
import java.util.Map;

public class java_17351_SessionManager_A07 {

    // Store session data in a Map
    private Map<String, Object> sessionData;

    public java_17351_SessionManager_A07() {
        sessionData = new HashMap<>();
    }

    // Method to add data to the session
    public void addData(String sessionId, Object data) {
        sessionData.put(sessionId, data);
    }

    // Method to get data from the session
    public Object getData(String sessionId) {
        return sessionData.get(sessionId);
    }

    // Method to remove data from the session
    public void removeData(String sessionId) {
        sessionData.remove(sessionId);
    }

    // Method to check if a sessionId exists
    public boolean isSessionActive(String sessionId) {
        return sessionData.containsKey(sessionId);
    }

    // Method to check if a user is authenticated
    public boolean isUserAuthenticated(String sessionId) {
        // Here, we're assuming that the user is authenticated if their session is active
        return isSessionActive(sessionId);
    }

    // Method to check if a user is authorized
    public boolean isUserAuthorized(String sessionId) {
        // Here, we're assuming that the user is authorized if they are authenticated
        return isUserAuthenticated(sessionId);
    }

    // Method to logout the user
    public void logout(String sessionId) {
        // Here, we're just removing the session data
        removeData(sessionId);
    }
}