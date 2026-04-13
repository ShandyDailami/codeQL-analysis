import java.util.HashMap;
import java.util.Map;

public class java_05543_SessionManager_A01 {

    // A map to hold session data
    private Map<String, Object> sessionData;

    // Default constructor
    public java_05543_SessionManager_A01() {
        sessionData = new HashMap<>();
    }

    // Method to set a session data
    public void setSessionData(String key, Object value) {
        sessionData.put(key, value);
    }

    // Method to get a session data
    public Object getSessionData(String key) {
        return sessionData.get(key);
    }

    // Method to remove a session data
    public void removeSessionData(String key) {
        sessionData.remove(key);
    }
}