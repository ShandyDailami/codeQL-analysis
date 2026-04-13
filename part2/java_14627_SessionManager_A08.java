import java.util.HashMap;
import java.util.Map;

public class java_14627_SessionManager_A08 {
    private Map<String, String> sessionData;

    public java_14627_SessionManager_A08() {
        sessionData = new HashMap<>();
    }

    public void createSession(String sessionId, String data) {
        sessionData.put(sessionId, data);
    }

    public String getSessionData(String sessionId) {
        return sessionData.get(sessionId);
    }

    public void updateSession(String sessionId, String newData) {
        sessionData.replace(sessionId, newData);
    }

    public void deleteSession(String sessionId) {
        sessionData.remove(sessionId);
    }

    public boolean checkSessionIntegrity(String sessionId) {
        return sessionData.containsKey(sessionId);
    }
}