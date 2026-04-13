import java.util.HashMap;
import java.util.Map;

public class java_16409_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_16409_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
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

        // Creating a session
        String sessionId = "session1";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Getting the user id from the session
        String user = sessionManager.getUserId(sessionId);
        System.out.println("User from session: " + user); // Should print "User from session: user1"

        // Deleting the session
        sessionManager.deleteSession(sessionId);

        // Checking if the session is valid
        boolean isValid = sessionManager.isValidSession(sessionId);
        System.out.println("Is valid session? " + isValid); // Should print "Is valid session? false"
    }
}