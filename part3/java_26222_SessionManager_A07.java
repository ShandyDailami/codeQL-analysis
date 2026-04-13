import java.util.ArrayList;
import java.util.List;

public class java_26222_SessionManager_A07 {

    private static List<String> activeSessions = new ArrayList<>();

    public static void main(String[] args) {
        try {
            // Start a new session
            startSession("Session1");

            // Attempt to access unauthorized resource
            accessUnauthorizedResource();

            // End the session
            endSession("Session1");

            // Attempt to access unauthorized resource again
            accessUnauthorizedResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startSession(String sessionId) throws Exception {
        if (activeSessions.contains(sessionId)) {
            throw new Exception("Session already active: " + sessionId);
        }
        activeSessions.add(sessionId);
        System.out.println("Started session: " + sessionId);
    }

    public static void endSession(String sessionId) throws Exception {
        if (!activeSessions.contains(sessionId)) {
            throw new Exception("No active session with id: " + sessionId);
        }
        activeSessions.remove(sessionId);
        System.out.println("Ended session: " + sessionId);
    }

    public static void accessUnauthorizedResource() throws Exception {
        // Simulate unauthorized access by checking if session is active
        if (activeSessions.isEmpty()) {
            throw new Exception("No active sessions");
        }
        System.out.println("Accessing unauthorized resource");
    }
}