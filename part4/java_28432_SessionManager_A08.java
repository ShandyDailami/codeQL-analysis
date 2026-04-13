import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_28432_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_28432_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        while (sessionMap.containsKey(sessionId)) {
            sessionId = UUID.randomUUID().toString();
        }
        sessionMap.put(sessionId, "Created by SessionManager");
        return sessionId;
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return "No session found";
    }
}