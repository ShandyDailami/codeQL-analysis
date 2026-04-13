import javax.management.RuntimeErrorException;
import java.util.HashMap;

public class java_06653_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_06653_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new RuntimeErrorException(new Throwable("Invalid session: " + sessionId));
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}