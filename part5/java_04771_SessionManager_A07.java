import java.util.HashMap;
import java.util.Map;

public class java_04771_SessionManager_A07 {
    private Map<String, String> sessionData;

    public java_04771_SessionManager_A07() {
        sessionData = new HashMap<>();
    }

    public void startSession(String username) {
        sessionData.put("username", username);
        System.out.println("Session started for user: " + username);
    }

    public void authenticate(String username, String password) {
        // Here you can add the logic to authenticate the user
        // If the authentication fails, throw an exception

        if (!username.equals("admin") || !password.equals("password")) {
            throw new AuthenticationFailureException();
        }
    }

    public String getUserName(String sessionId) {
        return sessionData.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionData.remove(sessionId);
        System.out.println("Session ended for user: " + sessionData.get(sessionId));
    }
}