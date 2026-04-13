import java.security.*;

public class java_00406_SessionManager_A01 {
    private MessageDigest digest;

    public java_00406_SessionManager_A01() {
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String hashSessionId(String sessionId) {
        byte[] hashed = digest.digest(sessionId.getBytes());
        return Base64.getEncoder().encodeToString(hashed);
    }

    public boolean validateSession(String sessionId) {
        String hashed = hashSessionId(sessionId);
        return hashed.equals(hashSessionId(sessionId));
    }
}