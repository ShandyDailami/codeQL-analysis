import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_16446_SessionManager_A03 {
    private Map<String, String> userMap;
    private Map<String, String> sessionMap;

    public java_16446_SessionManager_A03() {
        userMap = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public String createSession(String username, String password) {
        String passwordHash = hashPassword(password);
        userMap.put(username, passwordHash);

        String sessionId = createSessionId();
        sessionMap.put(sessionId, username);

        return sessionId;
    }

    public String authenticate(String username, String password) {
        String passwordHash = userMap.get(username);
        if (passwordHash != null && passwordHash.equals(hashPassword(password))) {
            return createSession(username, password);
        }
        return null;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String createSessionId() {
        return new SecureRandom().ints(16, 0, 10000)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(""));
    }
}