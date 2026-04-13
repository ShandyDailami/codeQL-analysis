import javax.management.RuntimeErrorException;
import java.util.HashMap;

public class java_35726_SessionManager_A08 {
    private HashMap<String, String> sessionDB;

    public java_35726_SessionManager_A08() {
        sessionDB = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionDB.containsKey(sessionId)) {
            throw new RuntimeErrorException(new Throwable("Session already exists: " + sessionId));
        } else {
            sessionDB.put(sessionId, userId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionDB.containsKey(sessionId)) {
            return sessionDB.get(sessionId);
        } else {
            throw new RuntimeErrorException(new Throwable("Session does not exists: " + sessionId));
        }
    }

    public void endSession(String sessionId) {
        if (sessionDB.containsKey(sessionId)) {
            sessionDB.remove(sessionId);
        } else {
            throw new RuntimeErrorException(new Throwable("Session does not exists: " + sessionId));
        }
    }

    public void validateSession(String sessionId) {
        try {
            getUserId(sessionId);
        } catch (Exception e) {
            throw new RuntimeErrorException(new Throwable("Invalid Session: " + sessionId));
        }
    }
}