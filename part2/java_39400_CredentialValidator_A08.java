import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_39400_CredentialValidator_A08 {

    private final MessageDigest messageDigest;
    private final SecureRandom secureRandom;

    public java_39400_CredentialValidator_A08() throws NoSuchAlgorithmException {
        this.messageDigest = MessageDigest.getInstance("SHA-256");
        this.secureRandom = new SecureRandom();
    }

    public String hashPassword(String password) {
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        byte[] hashedPasswordBytes = messageDigest.digest(passwordBytes);
        return Base64.getEncoder().encodeToString(hashedPasswordBytes);
    }

    public boolean verifyPassword(String password, String hashedPassword) throws NoSuchAlgorithmException {
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        byte[] hashedPasswordBytes = Base64.getDecoder().decode(hashedPassword);
        byte[] verifiedPasswordBytes = messageDigest.digest(passwordBytes);
        return MessageDigest.isEqual(hashedPasswordBytes, verifiedPasswordBytes);
    }

    public String generateRandomPassword(int length) {
        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890~!@#$%^&*()_+=";
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            password.append(allowedCharacters.charAt(secureRandom.nextInt(allowedCharacters.length())));
        }
        return password.toString();
    }
}