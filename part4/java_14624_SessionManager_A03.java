import java.util.HashMap;
import java.util.Map;

public class java_14624_SessionManager_A03 {
    private Map<Integer, String> sessionMap;
    private static int nextId = 1;

    public java_14624_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public int createSession(String sessionData) {
        int sessionId = nextId++;
        sessionMap.put(sessionId, sessionData);
        return sessionId;
    }

    public String getSessionData(int sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(int sessionId) {
        sessionMap.remove(sessionId);
    }
}