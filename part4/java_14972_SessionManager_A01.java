import java.util.HashMap;
import java.util.Map;

public class java_14972_SessionManager_A01 {
    private Map<String, String> sessionStore;

    public java_14972_SessionManager_A01() {
        sessionStore = new HashMap<>();
    }

    public void createSession(String sessionId, String username) {
        sessionStore.put(sessionId, username);
        System.out.println("Session created with ID: " + sessionId + " for user: " + username);
    }

    public void destroySession(String sessionId) {
        if (sessionStore.containsKey(sessionId)) {
            String username = sessionStore.get(sessionId);
            sessionStore.remove(sessionId);
            System.out.println("Session destroyed for user: " + username);
       
        } else {
            System.out.println("No session found for the given ID");
        }
    }
}