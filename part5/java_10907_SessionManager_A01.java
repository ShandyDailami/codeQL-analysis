import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class java_10907_SessionManager_A01 {
    private HashMap<String, HttpSession> sessionMap;

    public java_10907_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(HttpSession session) {
        sessionMap.put("sessionID", session);
    }

    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    public HttpSession getSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public boolean isSessionActive(String sessionID) {
        HttpSession session = sessionMap.get(sessionID);
        return (session != null && session.isActive());
    }
}