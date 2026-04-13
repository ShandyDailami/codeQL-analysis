import java.util.HashMap;
import java.util.UUID;

public class java_16431_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_16431_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, "active");
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void endSession(String sessionId) {
        String status = sessionMap.get(sessionId);
        if (status != null && status.equals("active")) {
            sessionMap.put(sessionId, "inactive");
        } else {
            System.out.println("No active session with id " + sessionId);
        }
    }
}