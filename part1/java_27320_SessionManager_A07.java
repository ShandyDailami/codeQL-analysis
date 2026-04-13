import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class java_27320_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_27320_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) throws NoSuchAlgorithmException {
        SecureRandom sr = new SecureRandom();
        String token = sr.nextBytes(16).toString();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String hash = md.digest(token.getBytes()).toString();

        sessionMap.put(hash, username);
        return hash;
    }

    public boolean authenticate(String session, String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String hash = md.digest(password.getBytes()).toString();

        return sessionMap.containsKey(session) && hash.equals(sessionMap.get(session));
    }
}