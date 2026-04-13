import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_22050_SessionManager_A07 {
    private MessageDigest md;
    private SecureRandom sr;

    public java_22050_SessionManager_A07() {
        try {
            md = MessageDigest.getInstance("SHA-256");
            sr = new SecureRandom();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String createSession(String password) {
        byte[] bytes = password.getBytes();
        md.update(bytes);
        byte[] digest = md.digest();
        return bytesToHex(digest);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public boolean authenticate(String password, String hashedPassword) {
        return hashedPassword.equals(createSession(password));
    }
}