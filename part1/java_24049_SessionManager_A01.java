import java.util.HashMap;
import java.util.Map;

public class java_24049_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_24049_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session " + sessionId + " already exists.");
        } else {
            sessionMap.put(sessionId, username);
            System.out.println("Started session " + sessionId + " for user " + username);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Ended session " + sessionId + " for user " + username);
        } else {
            System.out.println("Error: No session " + sessionId + " exists.");
        }
    }

    public void validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session " + sessionId + " is valid");
        } else {
            System.out.println("Error: No session " + sessionId + " exists.");
        }
    }
}