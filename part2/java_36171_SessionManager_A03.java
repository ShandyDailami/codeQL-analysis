import javax.servlet.http.*;
import java.util.*;

public class java_36171_SessionManager_A03 implements SessionListener {
    private Map<String, Session> sessionMap = new HashMap<>();

    @Override
    public void sessionCreated(SessionEvent se) {
        // This method is not used, but can be used to implement a more secure session management
        Session session = se.getSession();
        sessionMap.put(((HttpServletRequest) session.getRequest()).getRequestURI(), session);
    }

    @Override
    public void sessionDestroyed(SessionEvent se) {
        // This method is not used, but can be used to implement a more secure session management
        Session session = se.getSession();
        sessionMap.remove(((HttpServletRequest) session.getRequest()).getRequestURI());
    }

    public Session getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Invalid session ID");
        }
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}