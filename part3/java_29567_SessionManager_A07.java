import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;

public class java_29567_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_29567_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) throws LoginException {
        if (sessionMap.containsKey(username)) {
            throw new LoginException("Session already exists for user " + username);
        } else {
            sessionMap.put(username, "Active");
            System.out.println("Session started for user " + username);
        }
    }

    public void endSession(String username) throws LoginException {
        if (!sessionMap.containsKey(username)) {
            throw new LoginException("No session exists for user " + username);
        } else {
            sessionMap.put(username, "Inactive");
            System.out.println("Session ended for user " + username);
        }
    }

    public String getSessionStatus(String username) throws LoginException {
        if (!sessionMap.containsKey(username)) {
            throw new LoginException("No session exists for user " + username);
        } else {
            return sessionMap.get(username);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        try {
            sessionManager.startSession("user1");
            sessionManager.startSession("user2");
            System.out.println(sessionManager.getSessionStatus("user1"));
            System.out.println(sessionManager.getSessionStatus("user2"));
            sessionManager.endSession("user1");
            System.out.println(sessionManager.getSessionStatus("user1"));
        } catch (LoginException e) {
            System.out.println(e.getMessage());
        }
    }
}