import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_37907_SessionManager_A03 {
    private String secretKey;

    public java_37907_SessionManager_A03(String secretKey) {
        this.secretKey = secretKey;
    }

    public String createSession(String userId) throws NoSuchAlgorithmException {
        String input = userId + secretKey;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes());

        return bytesToHex(hash);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    public boolean validateSession(String sessionId, String userId) throws NoSuchAlgorithmException {
        String input = userId + secretKey;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes());

        return sessionId.equals(bytesToHex(hash));
    }
}