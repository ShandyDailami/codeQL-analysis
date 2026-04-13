import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class java_00517_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private SecureRandom random;

    public java_00517_SessionManager_A08() {
        sessionMap = new HashMap<>();
        random = new SecureRandom();
    }

    public String createSession(String username) {
        String token = generateToken();
        sessionMap.put(token, username);
        return token;
    }

    public String getUsername(String token) {
        return sessionMap.get(token);
    }

    public void deleteSession(String token) {
        sessionMap.remove(token);
    }

    private String generateToken() {
        return String.valueOf(random.nextLong());
    }
}