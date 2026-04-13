import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_26896_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_26896_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    public String createSession(String userId) throws NoSuchAlgorithmException {
        String sessionId = hashUserId(userId);
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserIdFromSession(String sessionId) {
        return sessions.get(sessionId);
    }

    private String hashUserId(String userId) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(userId.getBytes());
        return bytesToHex(hash);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    public void integrityFailure(String sessionId) throws NoSuchAlgorithmException {
        if(!isValidSession(sessionId)) {
            throw new IllegalStateException("Invalid Session");
        }

        String userId = getUserIdFromSession(sessionId);
        String expectedUserId = hashUserId(userId);

        if(!userId.equals(expectedUserId)) {
            throw new IntegrityFailureException("Integrity Failure: User ID has been tampered with");
        }
    }
}