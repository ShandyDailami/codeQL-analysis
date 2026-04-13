import java.util.HashMap;
import java.util.Map;

public class java_05134_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_05134_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        this.sessionMap.put(sessionId, username);
        System.out.println("Started session for user: " + username + " with session id: " + sessionId);
    }

    public String getUsername(String sessionId) {
        return this.sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        String username = this.sessionMap.get(sessionId);
        this.sessionMap.remove(sessionId);
        System.out.println("Ended session for user: " + username + " with session id: " + sessionId);
    }
}