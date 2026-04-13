import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_03680_CredentialValidator_A07 {
    private static final String SALT = "Salt";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "password";

        String hashedPassword = hashPassword(password, getSalt());

        System.out.println("Hashed Password: " + hashedPassword);
    }

    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        return encodedSalt;
    }

    private static String hashPassword(String password, String encodedSalt) throws NoSuchAlgorithmException {
        String passwordToHash = password + encodedSalt;
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] hashedPasswordBytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
        String encodedHashedPassword = Base64.getEncoder().encodeToString(hashedPasswordBytes);
        return encodedHashedPassword;
    }
}