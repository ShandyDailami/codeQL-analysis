import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_35032_CredentialValidator_A07 {
    private static final String SALT_ALGORITHM = "SHA1PRNG";
    private MessageDigest messageDigest;

    public java_35032_CredentialValidator_A07() {
        try {
            messageDigest = MessageDigest.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA1PRNG Algorithm not available.");
        }
    }

    public String generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return salt.toString();
    }

    public String hashPassword(String password, String salt) {
        messageDigest.reset();
        messageDigest.update(salt.getBytes());
        byte[] bytes = messageDigest.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public boolean validatePassword(String password, String salt, String hashedPassword) {
        return hashedPassword.equals(hashPassword(password, salt));
    }
}