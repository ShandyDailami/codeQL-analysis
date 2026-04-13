import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_26448_SessionManager_A08 {
    private String sessionId;

    public java_26448_SessionManager_A08() {
        this.sessionId = createSessionId();
    }

    private String createSessionId() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(System.currentTimeMillis() + sessionId);
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        System.out.println("Session ID: " + sessionManager.getSessionId());
        sessionManager.setSessionId("newSessionId");
        System.out.println("Updated Session ID: " + sessionManager.getSessionId());
    }
}