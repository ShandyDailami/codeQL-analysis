import java.util.HashMap;
import java.util.Map;

public class java_00913_SessionManager_A08 {
    // Use a HashMap to store session ids and objects
    private Map<String, Object> sessionMap;

    public java_00913_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(Object object) {
        if (object == null) {
            System.out.println("Creating a session failed because the object is null.");
            return null;
        }
        String sessionId = String.valueOf(object.hashCode()); // Assuming hashcode as session id
        sessionMap.put(sessionId, object);
        return sessionId;
    }

    // Method to get a session
    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session exists
    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to handle integrity failures (when a session object is null)
    public Object handleIntegrityFailure(String sessionId) {
        if (!hasSession(sessionId)) {
            System.out.println("Integrity failure occurred when getting session with id: " + sessionId);
            return null;
        }
        return getSession(sessionId);
    }
}