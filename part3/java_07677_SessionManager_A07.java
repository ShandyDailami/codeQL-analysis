// Java code starts here

import java.util.HashMap;
import java.util.Map;

public class java_07677_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_07677_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

// Java code ends here