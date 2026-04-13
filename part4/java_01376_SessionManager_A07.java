import java.util.HashMap;

public class java_01376_SessionManager_A07 {
    private HashMap<String, User> sessionData;

    public java_01376_SessionManager_A07() {
        sessionData = new HashMap<>();
    }

    public void createSession(String sessionId, User user) {
        sessionData.put(sessionId, user);
    }

    public User getUserFromSession(String sessionId) {
        return sessionData.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionData.remove(sessionId);
    }
}

public class User {
    private String username;
    private String password;

    public java_01376_SessionManager_A07(String username, String password) {
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