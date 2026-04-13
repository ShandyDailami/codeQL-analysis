import java.util.HashMap;
import java.util.Map;

public class java_32899_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_32899_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId) {
        sessionMap.put(userId, userId);
    }

    public String getUser(String userId) {
        return sessionMap.get(userId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("A07_AuthFailure");

        // Set the user
        String user = sessionManager.getUser("A07_AuthFailure");

        // Print the user
        System.out.println("User: " + user);
    }
}