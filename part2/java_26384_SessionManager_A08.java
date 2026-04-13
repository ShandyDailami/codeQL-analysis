import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_26384_SessionManager_A08 {

    private Map<String, String> sessions;

    public java_26384_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    public String createSession(String userId) throws NoSuchAlgorithmException {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(salt);
        byte[] hashedSalt = md.digest(salt);
        String hashedPassword = Base64.getEncoder().encodeToString(hashedSalt);
        sessions.put(userId, hashedPassword);
        return hashedPassword;
    }

    public String getSession(String userId, String hashedPassword) {
        String hashedSession = sessions.get(userId);
        if (hashedSession != null && hashedSession.equals(hashedPassword)) {
            return sessions.get(userId);
        }
        return null;
    }
}