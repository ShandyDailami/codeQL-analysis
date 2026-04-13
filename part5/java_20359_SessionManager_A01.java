import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = HttpSession.class, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class java_20359_SessionManager_A01 {

    private Map<String, HttpSession> sessionMap;

    @Autowired
    public java_20359_SessionManager_A01(HttpServletRequest request) {
        this.sessionMap = new HashMap<>();
        String sessionId = request.getSession().getId();
        this.sessionMap.put(sessionId, request.getSession());
    }

    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.invalidate();
        }
    }

    public boolean isValidSession(String sessionId) {
        HttpSession session = sessionMap.get(sessionId);
        return session != null && session.isValid();
    }
}