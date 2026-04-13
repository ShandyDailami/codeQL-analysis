import java.util.HashMap;
import java.util.Map;

public class java_40252_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_40252_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists: " + sessionId);
        } else {
            sessionMap.put(sessionId, userName);
            System.out.println("Started session: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Ended session: " + sessionId);
        } else {
            System.out.println("No session found for: " + sessionId);
        }
    }

    public String getSessionOwner(String sessionId) {
        return sessionMap.getOrDefault(sessionId, "No session found");
    }
}