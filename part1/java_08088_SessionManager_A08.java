import java.util.HashMap;
import java.util.Map;

public class java_08088_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_08088_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String user) {
        sessionMap.put(sessionId, user);
    }

    public String getUser(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "User not found";
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String user) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, user);
        } else {
            System.out.println("User not found");
        }
    }
}