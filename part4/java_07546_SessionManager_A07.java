import java.util.HashMap;
import java.util.Map;

// Import JSM
import java.security.Security;

public class java_07546_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_07546_SessionManager_A07() {
        sessionMap = new HashMap<>();
        // Add JSM to the security manager
        Security.addProvider(new SecurityProvider());
    }

    public String createSession(String user) {
        // Create a session and return a session ID
        String sessionID = "session-" + user;
        sessionMap.put(sessionID, user);
        return sessionID;
    }

    public String getUser(String sessionID) {
        // Get the user from the session ID
        return sessionMap.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        // Delete the session from the session map
        sessionMap.remove(sessionID);
    }
}

class SecurityProvider extends SecurityManager {
    @Override
    public boolean checkUser(String user) {
        // Check if the user is valid
        return true;
    }

    @Override
    public boolean checkPassword(String password) {
        // Check if the password is valid
        return true;
    }

    @Override
    public boolean checkDelete(String sessionID) {
        // Check if the sessionID is valid
        return true;
    }
}