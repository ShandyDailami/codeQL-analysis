import java.util.HashMap;
import java.util.Map;

public class java_12927_SessionManager_A03 {

    // Using a simple in-memory storage for demonstration purposes
    private Map<String, String> sessionStorage = new HashMap<>();

    public String getSessionId(String userName) {
        // This is a simple password storage. In real-world applications,
        // the passwords would be hashed and stored securely.
        String password = userName + "_password";
        String sessionId = sessionStorage.size() + "_" + userName;
        sessionStorage.put(sessionId, password);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        // Retrieving the password based on the sessionId
        String password = sessionStorage.get(sessionId);
        if (password != null) {
            return password.substring(0, password.indexOf("_"));
        } else {
            return null;
        }
    }

    public void invalidateSession(String sessionId) {
        // Invalidate the session by removing the sessionId and password from the storage
        sessionStorage.remove(sessionId);
    }
}