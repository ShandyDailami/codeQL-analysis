import java.util.HashMap;
import java.util.Map;

public class java_25250_SessionManager_A01 {
    private Map<String, String> sessionMap;
    private Map<String, String> passwordMap;

    public java_25250_SessionManager_A01() {
        sessionMap = new HashMap<>();
        passwordMap = new HashMap<>();
    }

    public void addSession(String sessionId, String password) {
        if (sessionId == null || password == null) {
            throw new IllegalArgumentException("Session ID and password must not be null");
        }
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Session ID already in use");
        }
        sessionMap.put(sessionId, password);
        passwordMap.put(password, sessionId);
    }

    public String getSession(String sessionId) {
        if (sessionId == null || !sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Invalid session ID");
        }
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        if (sessionId == null || !sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Invalid session ID");
        }
        String password = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        passwordMap.remove(password);
    }

    public boolean checkPassword(String sessionId, String password) {
        if (sessionId == null || !passwordMap.containsKey(password)) {
            throw new IllegalArgumentException("Invalid session ID or password");
        }
        return sessionId.equals(passwordMap.get(password));
    }
}