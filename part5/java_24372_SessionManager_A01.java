import java.util.HashMap;

public class java_24372_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_24372_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("Alice", "session1");
        sessionManager.startSession("Bob", "session2");

        System.out.println("Alice is " + (sessionManager.isValidSession("session1") ? "valid" : "invalid"));
        System.out.println("Bob is " + (sessionManager.isValidSession("session2") ? "valid" : "invalid"));

        sessionManager.endSession("session1");
        sessionManager.endSession("session2");

        System.out.println("Alice is " + (sessionManager.isValidSession("session1") ? "valid" : "invalid"));
        System.out.println("Bob is " + (sessionManager.isValidSession("session2") ? "valid" : "invalid"));
    }
}