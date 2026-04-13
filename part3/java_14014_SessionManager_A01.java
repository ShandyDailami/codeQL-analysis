import java.util.HashMap;
import java.util.Map;

public class java_14014_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_14014_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userName, String sessionId) {
        sessionMap.put(userName, sessionId);
    }

    public String getSession(String userName) {
        return sessionMap.get(userName);
    }

    public void deleteSession(String userName) {
        sessionMap.remove(userName);
    }
}