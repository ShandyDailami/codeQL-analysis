import java.util.HashMap;

public class java_37476_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_37476_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session already exists with id: " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Successfully created session with id: " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Successfully deleted session with id: " + sessionId);
        } else {
            System.out.println("Error: No session found with id: " + sessionId);
        }
    }

    public void accessSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            System.out.println("User with id: " + userId + " is accessing the session with id: " + sessionId);
        } else {
            System.out.println("Error: No session found with id: " + sessionId);
        }
    }

    public void integrityFailure() {
        // Simulate a failure in integrity.
        sessionMap.put("fakeSessionId", "fakeUserId");
        System.out.println("IntegrityFailure: Attempt to access non-existing session.");
    }
}