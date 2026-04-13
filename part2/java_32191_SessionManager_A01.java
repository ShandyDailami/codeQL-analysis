import java.util.HashMap;
import java.util.Map;

public class java_32191_SessionManager_A01 {

    private Map<String, String> userStore;
    private Map<String, String> sessionStore;

    public java_32191_SessionManager_A01() {
        userStore = new HashMap<>();
        sessionStore = new HashMap<>();
    }

    public String createUser(String username, String password) {
        if (userStore.containsKey(username)) {
            return null;
        }
        userStore.put(username, password);
        return username;
    }

    public String getUser(String username) {
        return userStore.get(username);
    }

    public String createSession(String username) {
        String sessionId = username + System.currentTimeMillis();
        sessionStore.put(sessionId, username);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionStore.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionStore.remove(sessionId);
    }

    public void endUser(String username) {
        userStore.remove(username);
    }

    public boolean isValidSession(String sessionId) {
        return sessionStore.containsKey(sessionId);
    }

    public boolean isValidUser(String username, String password) {
        return userStore.containsKey(username) && userStore.get(username).equals(password);
    }
}