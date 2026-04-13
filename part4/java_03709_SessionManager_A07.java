import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_03709_SessionManager_A07 implements HttpSessionListener {
    private static final long serialVersionUID = 1L;
    
    public static class SessionInfo {
        private String sessionId;
        private String userId;
        
        public java_03709_SessionManager_A07(String sessionId, String userId) {
            this.sessionId = sessionId;
            this.userId = userId;
        }
        
        public String getSessionId() {
            return sessionId;
        }
        
        public String getUserId() {
            return userId;
        }
    }
    
    private static final java.util.HashMap<String, SessionInfo> sessionMap = new java.util.HashMap<>();
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        SessionInfo sessionInfo = new SessionInfo(se.getSession().getId(), "User-" + se.getSession().getAttribute("userId"));
        sessionMap.put(se.getSession().getId(), sessionInfo);
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionMap.remove(se.getSession().getId());
    }
    
    public static SessionInfo getSessionInfo(String sessionId) {
        return sessionMap.get(sessionId);
    }
}