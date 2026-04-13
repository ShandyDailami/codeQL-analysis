import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_40496_SessionManager_A07 {
    private String salt;

    public java_40496_SessionManager_A07(String salt) {
        this.salt = salt;
    }

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String createSession(String password) {
        String hashedPassword = hashPassword(password);
        return hashPassword(hashedPassword + this.salt);
    }

    public String validateSession(String password, String session) {
        String hashedPassword = hashPassword(password);
        return session.equals(hashPassword(hashedPassword + this.salt)) ? "valid" : "invalid";
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}