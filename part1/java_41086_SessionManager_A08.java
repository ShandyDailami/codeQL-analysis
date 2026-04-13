import java.util.HashMap;
import java.util.Map;

public class java_41086_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_41086_SessionManager_A08() {
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

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // create a session
        String sessionId = "session1";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // get the user id from the session
        System.out.println("User ID from session: " + sessionManager.getUserId(sessionId));

        // check if a session is valid
        System.out.println("Is Valid Session: " + sessionManager.isValidSession(sessionId));

        // delete the session
        sessionManager.deleteSession(sessionId);

        // check if the session is valid after deletion
        System.out.println("Is Valid Session After Delete: " + sessionManager.isValidSession(sessionId));
    }

}