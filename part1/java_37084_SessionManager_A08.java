import java.util.HashMap;
import java.util.Map;

public class java_37084_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_37084_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session already exists. Please use a unique session ID.");
            return null;
        }
        sessionMap.put(sessionId, userId);
        return "Session created successfully.";
    }

    public String getUserIdBySessionId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session does not exist.");
            return null;
        }
        return sessionMap.get(sessionId);
    }

    public String deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session does not exist.");
            return null;
        }
        sessionMap.remove(sessionId);
        return "Session deleted successfully.";
    }
}