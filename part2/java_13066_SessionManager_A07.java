import java.util.HashMap;

public class java_13066_SessionManager_A07 {

    // Create a HashMap to store the active sessions.
    private static HashMap<Integer, String> activeSessions = new HashMap<>();

    // A static variable to generate unique IDs for sessions.
    private static int sessionId = 0;

    // Method to create a new session.
    public static String createSession() {
        sessionId++;
        activeSessions.put(sessionId, "Active");
        return "Session ID: " + sessionId;
    }

    // Method to end a session.
    public static void endSession(int sessionId) {
        activeSessions.remove(sessionId);
    }

    // Method to check if a session is active.
    public static String isSessionActive(int sessionId) {
        return activeSessions.getOrDefault(sessionId, "Inactive");
    }

    // Method to check if all sessions are active.
    public static boolean areAllSessionsActive() {
        return activeSessions.values().stream().noneMatch(status -> status.equals("Inactive"));
    }

    // Main method to test the session manager.
    public static void main(String[] args) {
        System.out.println(createSession());
        System.out.println(isSessionActive(1));
        endSession(1);
        System.out.println(isSessionActive(1));
        System.out.println(areAllSessionsActive());
    }
}