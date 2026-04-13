import java.util.HashMap;
import java.util.Map;

public class java_10237_SessionManager_A08 {
    // The session storage
    private Map<String, String> sessions;

    // Constructor
    public java_10237_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to add a session
    public String addSession(String key, String value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Session key and value must not be null.");
        }
        sessions.put(key, value);
        return value;
    }

    // Method to validate a session
    public String validateSession(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Session key must not be null.");
        }
        String value = sessions.get(key);
        if (value == null) {
            throw new SecurityException("Invalid session key.");
        }
        return value;
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Add a session
        sessionManager.addSession("A08_IntegrityFailure", "session_value");

        // Validate the session
        String sessionValue = sessionManager.validateSession("A08_IntegrityFailure");
        System.out.println("Session value: " + sessionValue);
    }
}