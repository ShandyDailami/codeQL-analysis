import java.util.HashMap;

public class java_08058_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_08058_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = null;
        if (username != null && !username.isEmpty()) {
            sessionId = username;
        }
        this.sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        if (sessionId != null && !sessionId.isEmpty() && this.sessionMap.containsKey(sessionId)) {
            return this.sessionMap.get(sessionId);
        } else {
            throw new SecurityException("Access Denied: Invalid Session Id");
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionId != null && !sessionId.isEmpty() && this.sessionMap.containsKey(sessionId)) {
            this.sessionMap.remove(sessionId);
        } else {
            throw new SecurityException("Access Denied: Invalid Session Id");
        }
    }

    public void integrityFailure(String sessionId) {
        if (sessionId != null && !sessionId.isEmpty() && this.sessionMap.containsKey(sessionId)) {
            this.sessionMap.put(sessionId, "INTEGRITY FAILURE");
        } else {
            throw new SecurityException("Access Denied: Invalid Session Id");
        }
    }
}