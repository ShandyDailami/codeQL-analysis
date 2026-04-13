import java.util.HashMap;
import java.util.Map;

public class java_42122_SessionManager_A08 {

    // Map to store sessions
    private Map<String, Object> sessions;

    public java_42122_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to create a session
    public void createSession(String key, Object value) {
        sessions.put(key, value);
    }

    // Method to retrieve a session
    public Object getSession(String key) {
        return sessions.get(key);
    }

    // Security-sensitive operation to add a session with a null key
    public void addSession(Object value) {
        if (value == null) {
            sessions.put(null, value); // This will fail to add the session
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.createSession("session1", "value1");
        manager.addSession(null);
    }
}