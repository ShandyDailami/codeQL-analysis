import java.util.HashMap;
import java.util.Map;

public class java_03627_SessionManager_A07 {
    private Map<String, String> userCredentials;
    private Map<String, String> sessionIDs;

    public java_03627_SessionManager_A07() {
        this.userCredentials = new HashMap<>();
        this.sessionIDs = new HashMap<>();
    }

    public String createSession(String username, String password) {
        if (isUserAuthenticated(username, password)) {
            String sessionID = generateSessionID(username);
            sessionIDs.put(sessionID, username);
            return sessionID;
        } else {
            return null;
        }
    }

    public String getSessionUser(String sessionID) {
        return sessionIDs.get(sessionID);
    }

    public boolean endSession(String sessionID) {
        if (sessionIDs.containsKey(sessionID)) {
            sessionIDs.remove(sessionID);
            return true;
        } else {
            return false;
        }
    }

    private boolean isUserAuthenticated(String username, String password) {
        // This is a placeholder, you should replace this with your actual authentication logic
        // For now, we just check if the username and password are both not null
        return username != null && password != null;
    }

    private String generateSessionID(String username) {
        // This is a placeholder, you should replace this with your actual session ID generation logic
        // For now, we just return the username as the session ID
        return username;
    }
}