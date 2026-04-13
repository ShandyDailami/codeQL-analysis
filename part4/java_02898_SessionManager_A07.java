import java.util.HashMap;

public class java_02898_SessionManager_A07 {
    private HashMap<String, String> sessionData;

    public java_02898_SessionManager_A07() {
        sessionData = new HashMap<>();
    }

    public String getSessionData(String sessionId) {
        return sessionData.get(sessionId);
    }

    public void setSessionData(String sessionId, String data) {
        sessionData.put(sessionId, data);
    }

    public void removeSessionData(String sessionId) {
        sessionData.remove(sessionId);
    }
}