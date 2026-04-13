import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class java_32203_SessionManager_A07 {

    private Map<String, HttpSession> sessionMap;

    public java_32203_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(HttpServletRequest request, String sessionId) {
        HttpSession session = request.getSession();
        session.setId(sessionId);
        sessionMap.put(sessionId, session);
    }

    public void deleteSession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.invalidate();
            sessionMap.remove(sessionId);
        }
    }

    public void validateSession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session == null || session.isInvalid()) {
            throw new AuthenticationFailureException("Invalid session");
        }
    }
}