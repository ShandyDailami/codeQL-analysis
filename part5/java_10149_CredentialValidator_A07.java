import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_10149_CredentialValidator_A07 {

    // A random number to use as a salt for the hash
    private final SecureRandom sr = new SecureRandom();

    // The message digest to use
    private final MessageDigest md;

    // The salt to use
    private final byte[] salt = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    // Whether to use a secure hash function or not
    private final boolean secureHash;

    public java_10149_CredentialValidator_A07(boolean secureHash) {
        this.secureHash = secureHash;
        try {
            this.md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String createSaltedHash(String password) {
        this.md.update(this.salt);
        byte[]盐后的密码 = this.md.digest(password.getBytes());
        this.md.update(盐后的密码);
        byte[] 哈希后的密码 = this.md.digest();
        return Base64.getEncoder().encodeToString(哈希后的密码);
    }

    public boolean validate(String password, String hash) {
        if (this.secureHash) {
            return this.createSaltedHash(password).equals(hash);
        } else {
            return hash.equals(this.createSaltedHash(password));
        }
    }
}