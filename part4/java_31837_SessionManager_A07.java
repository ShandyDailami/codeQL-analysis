import java.util.HashMap;
import java.util.Map;

public class java_31837_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_31837_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String username = "admin";
        String sessionId = "A123";

        sessionManager.createSession(username, sessionId);

        if (sessionManager.isValidSession(sessionId)) {
            String user = sessionManager.getUsername(sessionId);
            System.out.println("User " + user + " logged in.");
        } else {
            System.out.println("Invalid session.");
        }

        sessionManager.deleteSession(sessionId);

        if (!sessionManager.isValidSession(sessionId)) {
            System.out.println("User logged out.");
        } else {
            System.out.println("Failed to log out user.");
        }
    }
}