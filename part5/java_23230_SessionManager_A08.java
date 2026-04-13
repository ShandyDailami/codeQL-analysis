import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_23230_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private SecureRandom random;

    public java_23230_SessionManager_A08() {
        sessionMap = new HashMap<>();
        random = new SecureRandom();
    }

    public String createSession(String username) {
        String sessionKey = createSessionKey();
        sessionMap.put(sessionKey, username);
        return sessionKey;
    }

    public String getUsername(String sessionKey) {
        return sessionMap.get(sessionKey);
    }

    public void deleteSession(String sessionKey) {
        sessionMap.remove(sessionKey);
    }

    private String createSessionKey() {
        byte[] randomBytes = new byte[16];
        random.nextBytes(randomBytes);
        String secureSessionKey = Base64.getEncoder().encodeToString(randomBytes);
        return secureSessionKey;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionKey = sessionManager.createSession("user1");
        System.out.println("Created session key: " + sessionKey);

        String username = sessionManager.getUsername(sessionKey);
        System.out.println("Username: " + username);

        sessionManager.deleteSession(sessionKey);
    }
}