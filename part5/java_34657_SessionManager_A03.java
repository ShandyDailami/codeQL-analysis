import java.util.HashMap;
import java.util.Map;

public class java_34657_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_34657_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = "123";
        String userId = "abc";

        sessionManager.createSession(sessionId, userId);

        String user = sessionManager.getUserId(sessionId);

        System.out.println("User ID: " + user);

        sessionManager.destroySession(sessionId);
    }
}