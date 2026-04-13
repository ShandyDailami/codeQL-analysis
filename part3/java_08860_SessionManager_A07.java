import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class java_08860_SessionManager_A07 {
    private Map<String, HttpSession> sessionMap;

    public java_08860_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String username, HttpSession session) {
        sessionMap.put(username, session);
    }

    public void removeSession(String username) {
        sessionMap.remove(username);
    }

    public HttpSession getSession(String username) {
        return sessionMap.get(username);
    }

    public boolean isValidSession(String username) {
        return sessionMap.containsKey(username);
    }
}