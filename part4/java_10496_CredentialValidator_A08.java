import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_10496_CredentialValidator_A08 {

    private String expectedPassword;

    public java_10496_CredentialValidator_A08(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    public boolean validate(String password) {
        if (password == null) {
            return false;
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());

            StringBuilder hashBuilder = new StringBuilder(hashBytes.length * 2);

            for (byte b : hashBytes) {
                hashBuilder.append(String.format("%02x", b & 0xff));
            }

            String expectedPasswordHash = hashBuilder.toString();

            return expectedPasswordHash.equals(this.expectedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm not available", e);
        }
    }
}