import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_23806_CredentialValidator_A07 {
    private final MessageDigest messageDigest;
    private final SecureRandom secureRandom;

    public java_23806_CredentialValidator_A07() {
        try {
            this.messageDigest = MessageDigest.getInstance("SHA-256");
            this.secureRandom = new SecureRandom();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String generateSalt() {
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return saltToString(salt);
    }

    public String hashPassword(String password, String salt) {
        messageDigest.update(salt.getBytes());
        byte[] bytes = messageDigest.digest(password.getBytes());
        return bytesToString(bytes);
    }

    private String saltToString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    private String bytesToString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    public boolean isValidPassword(String password, String salt, String hashedPassword, CredentialValidator validator) {
        String hashedInputPassword = validator.hashPassword(password, salt);
        return hashedInputPassword.equals(hashedPassword);
    }
}