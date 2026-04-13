import java.util.HashMap;
import java.util.Map;

public class java_10599_SessionManager_A07 {
    private Map<String, String> loginCredentials;

    public java_10599_SessionManager_A07() {
        loginCredentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        loginCredentials.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        if (loginCredentials.containsKey(username) &&
            loginCredentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}

public class SessionManager {
    private AuthFailureManager authFailureManager;
    private Map<String, String> sessionMap;

    public java_10599_SessionManager_A07(AuthFailureManager authFailureManager) {
        this.authFailureManager = authFailureManager;
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (authFailureManager.authenticate(username, password)) {
            sessionMap.put(username, password);
        } else {
            System.out.println("Authentication failed, session not started.");
        }
    }

    public void endSession(String username) {
        sessionMap.remove(username);
    }

    public boolean isSessionActive(String username) {
        return sessionMap.containsKey(username);
    }
}