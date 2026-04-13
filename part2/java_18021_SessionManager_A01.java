import javax.management.RuntimeErrorException;
import java.util.HashMap;

public class java_18021_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_18021_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new RuntimeErrorException(new Throwable("Invalid session ID"));
        }
    }

    public void removeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new RuntimeErrorException(new Throwable("Invalid session ID"));
        }
    }
}