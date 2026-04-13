import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_39783_SessionManager_A07 {

    private Map<String, String> sessions;

    public java_39783_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    public String createSession(String username, String password) {
        String hashedPassword = hashPassword(password);
        String sessionId = generateSessionId();
        this.sessions.put(sessionId, hashedPassword);
        return sessionId;
    }

    public boolean authenticate(String sessionId, String password) {
        if (!this.sessions.containsKey(sessionId)) {
            return false;
        }
        String hashedPassword = this.sessions.get(sessionId);
        return hashedPassword.equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String generateSessionId() {
        // You could use UUIDs here instead of strings
        return "session_id";
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}