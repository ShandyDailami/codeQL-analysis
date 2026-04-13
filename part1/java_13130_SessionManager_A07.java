import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class java_13130_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_13130_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        sessionMap.put(sessionId, "Session data");
        return sessionId;
    }

    public String getSessionData(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalStateException("Session not found");
        }
    }

    public void deleteSession(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        sessionMap.remove(sessionId);
    }
}