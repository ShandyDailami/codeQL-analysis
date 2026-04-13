import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_23445_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_23445_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, "active");
        return sessionId;
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Session not found";
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("Session not found");
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        String sessionId = sm.createSession();
        System.out.println("Created session with ID: " + sessionId);
        String sessionStatus = sm.getSession(sessionId);
        System.out.println("Session status: " + sessionStatus);
        sm.deleteSession(sessionId);
        sessionStatus = sm.getSession(sessionId);
        System.out.println("Session status after deletion: " + sessionStatus);
    }
}