import javax.management.RuntimeErrorException;
import java.util.HashMap;
import java.util.Map;

public class java_17691_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_17691_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeErrorException(new Throwable("Session " + sessionId + " already exists."));
        } else {
            sessionMap.put(sessionId, value);
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new RuntimeErrorException(new Throwable("Session " + sessionId + " does not exist."));
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new RuntimeErrorException(new Throwable("Session " + sessionId + " does not exist."));
        }
    }

    public void updateSession(String sessionId, String newValue) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newValue);
        } else {
            throw new RuntimeErrorException(new Throwable("Session " + sessionId + " does not exist."));
        }
    }
}