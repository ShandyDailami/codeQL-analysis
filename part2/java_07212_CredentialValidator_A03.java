import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_07212_CredentialValidator_A03 {

    private final MessageDigest messageDigest;
    private final SecureRandom secureRandom;

    public java_07212_CredentialValidator_A03() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("SHA-256");
        secureRandom = new SecureRandom();
    }

    public String hashPassword(String password) {
        byte[] passwordBytes = password.getBytes();
        byte[] hashedBytes = messageDigest.digest(passwordBytes);
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    public boolean validatePassword(String password, String hashedPassword) {
        byte[] passwordBytes = password.getBytes();
        byte[] hashedPasswordBytes = Base64.getDecoder().decode(hashedPassword);
        byte[] hashedCheckBytes = messageDigest.digest(passwordBytes);
        return MessageDigest.isEqual(hashedPasswordBytes, hashedCheckBytes);
    }

    public String createRandomPassword(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(alphabet.charAt(secureRandom.nextInt(alphabet.length())));
        }
        return sb.toString();
    }
}