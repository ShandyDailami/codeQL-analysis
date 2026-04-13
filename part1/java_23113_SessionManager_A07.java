import java.util.HashMap;
import java.util.Map;

public class java_23113_SessionManager_A07 {
    private Map<String, String> credentials;

    public java_23113_SessionManager_A07() {
        // Initialize the credentials map. This should be a secure way to store credentials.
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public String createSession(String username, String password) {
        // Check if the provided username and password match.
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            // If they match, create a new session ID and store it in a secure place.
            String sessionID = UUID.randomUUID().toString();
            return sessionID;
        } else {
            // If they don't match, return null.
            return null;
        }
    }

    public void deleteSession(String sessionID) {
        // Remove the session from the map.
        credentials.remove(sessionID);
    }
}