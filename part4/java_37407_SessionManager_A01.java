import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_37407_SessionManager_A01 {
    private Map<String, String> sessionMap;
    private Map<String, String> userMap;
    private SecureRandom random;

    public java_37407_SessionManager_A01() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
        random = new SecureRandom();
    }

    // User Registration
    public void registerUser(String username, String password) {
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
        userMap.put(username, hashedPassword);
    }

    // User Authentication
    public boolean authenticateUser(String username, String password) {
        if (userMap.containsKey(username)) {
            String storedPassword = userMap.get(username);
            String hashedInput = hashPassword(password, storedPassword);
            return hashedInput.equals(storedPassword);
        } else {
            return false;
        }
    }

    // Session Creation
    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Session Destruction
    public void destroySession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            // Remove session from user's map if this session is the last one.
            userMap.values().removeIf(hashedPassword -> hashedPassword.equals(username));
        }
    }

    // Session Validation
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Helper methods
    private String generateSalt() {
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    private String hashPassword(String password, String salt) {
        String hashedPassword;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            hashedPassword = password;
        }
        return hashedPassword;
    }

    private String generateSessionId() {
        return java.util.UUID.randomUUID().toString();
    }
}