import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_29994_SessionManager_A03 implements HttpSessionListener {

    private static Map<String, HttpSession> sessionMap;

    public java_29994_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionMap.put(se.getSession().getId(), se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionMap.remove(se.getSession().getId());
    }

    public static HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }
}