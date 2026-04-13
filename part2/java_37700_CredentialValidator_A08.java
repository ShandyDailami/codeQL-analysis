import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_37700_CredentialValidator_A08 {
    private SecureRandom random;

    public java_37700_CredentialValidator_A08() {
        this.random = new SecureRandom();
    }

    public String createSalt() {
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public String createHash(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt.getBytes());
        byte[] bytes = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(bytes);
    }

    public boolean verify(String password, String salt, String hash) throws NoSuchAlgorithmException {
        return hash.equals(createHash(password, salt));
    }
}