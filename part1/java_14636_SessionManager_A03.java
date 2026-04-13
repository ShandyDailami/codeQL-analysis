import java.util.HashMap;
import java.util.Map;

public class java_14636_SessionManager_A03 {

    // A map for storing session data.
    private Map<String, String> sessionData = new HashMap<>();

    // A map for storing usernames and passwords.
    private Map<String, String> userCredentials = new HashMap<>();

    // Constructor.
    public java_14636_SessionManager_A03() {
        // Add some default users.
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    // Method to authenticate a user.
    public boolean authenticate(String user, String password) {
        if (userCredentials.containsKey(user) &&
            userCredentials.get(user).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // Method to start a session.
    public void startSession(String user) {
        if (authenticate(user, userCredentials.get(user))) {
            sessionData.put("user", user);
        } else {
            throw new SecurityException("Authentication failed for user: " + user);
        }
    }

    // Method to get the session data.
    public Map<String, String> getSessionData() {
        if (sessionData.containsKey("user")) {
            return sessionData;
        } else {
            throw new SecurityException("No session found for user: " + sessionData.get("user"));
        }
    }

    // Method to end the session.
    public void endSession(String user) {
        if (sessionData.containsKey("user") && sessionData.get("user").equals(user)) {
            sessionData.clear();
        } else {
            throw new SecurityException("Could not end session for user: " + user);
        }
    }
}