import java.util.HashMap;

public class java_33659_SessionManager_A08 {
    private HashMap<String, String> userMap;

    public java_33659_SessionManager_A08() {
        userMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = UUID.randomUUID().toString();
        userMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return userMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        userMap.remove(sessionId);
    }

    public boolean validateSession(String sessionId) {
        return userMap.containsKey(sessionId);
    }
}