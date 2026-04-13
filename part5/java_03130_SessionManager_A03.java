import java.util.HashMap;

public class java_03130_SessionManager_A03 {

    private HashMap<String, String> sessionStorage;

    public java_03130_SessionManager_A03() {
        sessionStorage = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessionStorage.containsKey(sessionId)) {
            return sessionStorage.get(sessionId);
        } else {
            return null;
        }
    }

    public void putSession(String sessionId, String sessionData) {
        sessionStorage.put(sessionId, sessionData);
    }

    public void removeSession(String sessionId) {
        if (sessionStorage.containsKey(sessionId)) {
            sessionStorage.remove(sessionId);
        }
    }
}