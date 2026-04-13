import java.util.HashMap;

public class java_27993_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_27993_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSessionValue(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Create a session
        manager.createSession("session1", "value1");

        // Get the session value
        String value = manager.getSessionValue("session1");
        System.out.println("Value: " + value);

        // Delete the session
        manager.deleteSession("session1");
    }
}