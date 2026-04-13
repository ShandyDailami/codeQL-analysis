import java.util.HashMap;
import java.util.Map;

public class java_11268_SessionManager_A07 {
    private Map<String, String> userMap;

    public java_11268_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public String getUser(String sessionId) {
        if (sessionId == null) {
            return null;
        }
        return userMap.get(sessionId);
    }

    public void setUser(String sessionId, String user) {
        userMap.put(sessionId, user);
    }

    public void removeUser(String sessionId) {
        userMap.remove(sessionId);
    }

    public void authFailure(String sessionId) {
        if (getUser(sessionId) != null) {
            System.out.println("Authentication failure detected for user: " + getUser(sessionId));
            removeUser(sessionId);
        }
    }
}