import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class java_19125_SessionManager_A03 {
    private Map<String, HttpSession> sessionMap;

    public java_19125_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public HttpSession getSession(String sessionId, HttpServletRequest request) {
        // Create a new session if it doesn't exist
        if (!sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, request.getSession());
        }

        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId, HttpServletRequest request) {
        // Destroy a session if it exists
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.get(sessionId).invalidate();
            sessionMap.remove(sessionId);
        }
    }

    public void addSecurityContext(String sessionId, SecurityContext context) {
        // Add security context to session
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.get(sessionId).setAttribute("SecurityContext", context);
        }
    }

    public SecurityContext getSecurityContext(String sessionId) {
        // Get security context from session
        if (sessionMap.containsKey(sessionId)) {
            return (SecurityContext) sessionMap.get(sessionId).getAttribute("SecurityContext");
        }
        return null;
    }

    public void destroySecurityContext(String sessionId) {
        // Destroy security context from session
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.get(sessionId).removeAttribute("SecurityContext");
        }
    }
}