import java.util.HashMap;
import java.util.Map;

public class java_16361_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_16361_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String userName, String password) {
        if (isValidUser(userName, password)) {
            String sessionId = generateSessionId();
            sessionMap.put(sessionId, userName);
            return sessionId;
        } else {
            return null;
        }
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private boolean isValidUser(String userName, String password) {
        // Here we would typically use a database or a real security service to validate the user
        // This is a placeholder, it just checks if the user is not null and the password is not empty
        return userName != null && !userName.isEmpty() && password != null && !password.isEmpty();
    }

    private String generateSessionId() {
        // Here we would typically use a UUID service to generate a session id
        // This is a placeholder, it just generates a random UUID
        return java.util.UUID.randomUUID().toString();
    }
}