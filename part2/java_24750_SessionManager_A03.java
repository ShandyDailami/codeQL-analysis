import java.util.HashMap;
import java.util.Map;

public class java_24750_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_24750_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "User1");
        System.out.println("User name: " + sessionManager.getUserName("session1"));

        sessionManager.createSession("session2", "User2");
        System.out.println("User name: " + sessionManager.getUserName("session2"));

        sessionManager.destroySession("session1");
        System.out.println("User name after destroying session1: " + sessionManager.getUserName("session1"));
    }
}