import java.util.HashMap;

public class java_05711_SessionManager_A08 {

    private HashMap<String, User> sessionMap;

    public java_05711_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(User user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        // Add code here to manage session start logic (e.g. log session start)
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
        // Add code here to manage session end logic (e.g. log session end)
    }

    public User getUserBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    private String generateSessionId() {
        // Add code here to generate session ID
        return "sessionID";
    }
}

public class User {
    private String name;

    public java_05711_SessionManager_A08(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}