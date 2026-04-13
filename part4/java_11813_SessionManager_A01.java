import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class java_11813_SessionManager_A01 {
    private Map<String, String> sessionMap;
    private SecureRandom random;

    public java_11813_SessionManager_A01() {
        sessionMap = new HashMap<>();
        random = new SecureRandom();
    }

    public String createSession(String username) {
        String sessionKey;
        do {
            sessionKey = randomSessionKey();
        } while (sessionMap.containsKey(sessionKey));

        sessionMap.put(sessionKey, username);

        return sessionKey;
    }

    public String getUsername(String sessionKey) {
        return sessionMap.get(sessionKey);
    }

    public void endSession(String sessionKey) {
        sessionMap.remove(sessionKey);
    }

    private String randomSessionKey() {
        return String.valueOf(random.nextLong());
    }
}