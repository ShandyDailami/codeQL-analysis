import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_02415_CredentialValidator_A08 {

    private static final String SHA_256 = "SHA-256";

    private final MessageDigest messageDigest;

    public java_02415_CredentialValidator_A08() {
        try {
            messageDigest = MessageDigest.getInstance(SHA_256);
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidParameterException("Error: No such algorithm.", e);
        }
    }

    public byte[] hashPassword(String password) {
        return messageDigest.digest(password.getBytes());
    }

    public boolean verifyPassword(String password, byte[] hashedPassword) {
        return MessageDigest.isEqual(hashPassword(password), hashedPassword);
    }

    public static void main(String[] args) {
        HashedCredentialValidator validator = new HashedCredentialValidator();

        // Example usage:
        String password = "password";
        byte[] hashedPassword = validator.hashPassword(password);

        System.out.println(validator.verifyPassword(password, hashedPassword)); // Outputs: true
    }
}