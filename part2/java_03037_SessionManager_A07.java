import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_03037_SessionManager_A07 {
    private Map<String, String> sessionMap;
    private SecureRandom random;

    public java_03037_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
        this.random = new SecureRandom();
    }

    public String createSession(String username) {
        String token = createRandomToken();
        sessionMap.put(token, username);
        return token;
    }

    public String getUsername(String token) {
        return sessionMap.get(token);
    }

    public void removeSession(String token) {
        sessionMap.remove(token);
    }

    private String createRandomToken() {
        byte[] randomBytes = new byte[16];
        random.nextBytes(randomBytes);
        return Base64.getUrlEncoder().encodeToString(randomBytes);
    }
}