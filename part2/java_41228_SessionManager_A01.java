import java.util.HashMap;
import java.util.Map;

public class java_41228_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_41228_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
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
        System.out.println("User in session: " + user); // should print "User in session: user1"

        // Deleting the session
        sessionManager.deleteSession(sessionId);
    }
}