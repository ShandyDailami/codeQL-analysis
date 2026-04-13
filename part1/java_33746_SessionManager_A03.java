import java.util.HashMap;
import java.util.Map;

public class java_33746_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_33746_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = user + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        String user = "testUser";
        String sessionId = sm.createSession(user);

        System.out.println("Session ID: " + sessionId);
        System.out.println("User: " + sm.getUser(sessionId));

        sm.deleteSession(sessionId);
    }
}