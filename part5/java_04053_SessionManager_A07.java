public class java_04053_SessionManager_A07 {
    private String username;
    private String password;

    public java_04053_SessionManager_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class SessionManager {
    private HashMap<String, UserCredentials> sessionMap;

    public java_04053_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(UserCredentials userCredentials) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userCredentials);
        return sessionId;
    }

    public UserCredentials getUserBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}