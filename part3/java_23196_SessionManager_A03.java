import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_23196_SessionManager_A03 {
    private static final String ALGORITHM = "SHA-256";
    private static final int KEY_LENGTH = 16;

    private SecureRandom random = new SecureRandom();
    private MessageDigest digest = null;

    public java_23196_SessionManager_A03() {
        try {
            digest = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public String createSession(String username) {
        byte[] bytes = new byte[KEY_LENGTH];
        random.nextBytes(bytes);
        byte[] encodedBytes = Base64.getEncoder().encode(bytes);

        String passwordHash = bytesToHex(encodedBytes);
        return username + passwordHash;
    }

    public String decryptSession(String encryptedSession) {
        byte[] bytes = encryptedSession.getBytes();
        byte[] decodedBytes = Base64.getDecoder().decode(bytes);

        return new String(decodedBytes);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            hex.append(String.format("%02X", b));
        }
        return hex.toString();
    }
}