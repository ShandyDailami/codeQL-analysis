import java.util.HashMap;

public class java_05668_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_05668_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        String sessionId = String.valueOf(sessionMap.size() + 1);
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to get the username for a given session
    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to end the session for a given session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        CustomSessionManager sessionManager = new CustomSessionManager();

        String sessionId = sessionManager.createSession("Alice");
        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username: " + username); // Alice

        sessionManager.endSession(sessionId);

        // Attempt to access session
        String endSessionUsername = sessionManager.getUsername(sessionId);
        System.out.println("End Session Username: " + endSessionUsername); // null
    }
}