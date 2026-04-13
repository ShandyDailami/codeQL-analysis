import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_35418_CredentialValidator_A07 {
    private String password;

    public java_35418_CredentialValidator_A07(String password) {
        this.password = hashPassword(password);
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

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public boolean validatePassword(String attempt) {
        return hashPassword(attempt).equals(password);
    }
}