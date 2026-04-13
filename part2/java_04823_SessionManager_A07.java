import java.util.HashMap;
import java.util.Map;

public class java_04823_SessionManager_A07 {

    // Using HashMap to simulate a database
    private Map<String, String> sessionDB;

    public java_04823_SessionManager_A07() {
        sessionDB = new HashMap<>();
    }

    // Create a session
    public String createSession(String userName) {
        // Generate a session id
        String sessionId = userName + System.currentTimeMillis();
        sessionDB.put(sessionId, userName);
        return sessionId;
    }

    // Retrieve user based on session id
    public String getUserNameBySessionId(String sessionId) {
        return sessionDB.get(sessionId);
    }

    // Validate a session
    public boolean validateSession(String sessionId) {
        // Assume if sessionId is present in the DB, the session is valid
        return sessionDB.containsKey(sessionId);
    }

    // Terminate a session
    public void endSession(String sessionId) {
        sessionDB.remove(sessionId);
    }
}