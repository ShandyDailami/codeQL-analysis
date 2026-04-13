import java.util.HashMap;
import java.util.Map;

public class java_39818_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_39818_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String user) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists");
            return;
        }
        sessionMap.put(sessionId, user);
        System.out.println("Session started for user: " + user);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session found for sessionId: " + sessionId);
            return;
        }
        sessionMap.remove(sessionId);
        System.out.println("Session ended for user: " + sessionMap.get(sessionId));
    }
}