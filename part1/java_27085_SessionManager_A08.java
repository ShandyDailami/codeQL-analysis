import java.util.*;

class java_27085_SessionManager_A08 {
    private Map<String, String> sessionMap = new HashMap<>();

    public String createSession(String userID) {
        String sessionID = UUID.randomUUID().toString();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getUserID(String sessionID) {
        return sessionMap.getOrDefault(sessionID, "Unknown");
    }

    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    public boolean isValidSession(String sessionID) {
        return sessionMap.containsKey(sessionID);
    }
}

class Main {
    public static void main(String[] args) {
        SecuritySessionManager sessionManager = new SecuritySessionManager();

        // Create a session for user A
        String sessionA = sessionManager.createSession("A08_IntegrityFailure");

        // Attempt to access user B
        System.out.println(sessionManager.getUserID(sessionA)); // Should print: Unknown

        // Delete session A
        sessionManager.deleteSession(sessionA);

        // Attempt to access user B after deleting session A
        System.out.println(sessionManager.getUserID(sessionA)); // Should print: Unknown
    }
}