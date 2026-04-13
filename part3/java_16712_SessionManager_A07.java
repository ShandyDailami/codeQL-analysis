import java.util.HashMap;
import java.util.Map;

public class java_16712_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_16712_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String md5Id = md5(userId);
        sessionMap.put(md5Id, userId);
        return md5Id;
    }

    public String getSession(String sessionId) {
        String md5Id = md5(sessionId);
        return sessionMap.get(md5Id);
    }

    private String md5(String input) {
        // Simple MD5 hash function, remove in real application
        return input;
    }
}