import java.util.HashMap;

public class java_14113_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_14113_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getSessionUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Creating a session for user 'John'
        sessionManager.createSession("session1", "John");

        // Getting user name from 'session1'
        String userName = sessionManager.getSessionUserName("session1");
        System.out.println("User name: " + userName);

        // Deleting 'session1'
        sessionManager.deleteSession("session1");
    }
}