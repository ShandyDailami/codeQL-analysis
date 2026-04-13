import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;

public class java_08651_SessionManager_A07 {
    private HashMap<String, String> sessionMap;
    private SecureRandom sr;

    public java_08651_SessionManager_A07() {
        sessionMap = new HashMap<>();
        sr = new SecureRandom();
    }

    public String createSession(String username) {
        String sessionId = createRandomSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsernameFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String createRandomSessionId() {
        byte[] randomBytes = new byte[16];
        sr.nextBytes(randomBytes);
        String randomString = new String(Base64.getEncoder().encode(randomBytes));
        return randomString;
    }
}