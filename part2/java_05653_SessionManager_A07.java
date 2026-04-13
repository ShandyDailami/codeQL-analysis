import java.util.HashMap;
import java.util.Map;

public class java_05653_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_05653_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method for starting the session.
    public String startSession(String userName) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    // Method for ending the session.
    public String endSession(String sessionId) {
        String userName = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        return userName;
    }

    // Method for authenticating the user.
    public boolean authenticateUser(String sessionId, String password) {
        // For simplicity, let's say the password is correct.
        // In reality, you should store the hashed passwords.
        String userName = sessionMap.get(sessionId);
        if (userName != null && password.equals("correctPassword")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        String sessionId = sessionManager.startSession("user1");
        System.out.println("Started session: " + sessionId);

        boolean authenticated = sessionManager.authenticateUser(sessionId, "correctPassword");
        System.out.println("Authenticated: " + authenticated);

        sessionId = sessionManager.startSession("user2");
        System.out.println("Started session: " + sessionId);

        authenticated = sessionManager.authenticateUser(sessionId, "incorrectPassword");
        System.out.println("Authenticated: " + authenticated);

        System.out.println("Ending session: " + sessionId);
        sessionManager.endSession(sessionId);
    }
}