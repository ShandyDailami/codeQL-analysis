import java.util.HashMap;
import java.util.Map;

public class java_38413_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_38413_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "value1");
        sessionManager.createSession("session2", "value2");

        System.out.println("Does session1 exist? " + sessionManager.hasSession("session1"));
        System.out.println("Does session3 exist? " + sessionManager.hasSession("session3"));

        System.out.println("Get session1: " + sessionManager.getSession("session1"));

        sessionManager.deleteSession("session1");

        System.out.println("Does session1 exist? " + sessionManager.hasSession("session1"));
    }
}