import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_35110_CredentialValidator_A07 {

    private static final String SALT_STRING = "SALT";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "password";
        String salt = getSalt();
        String hashedPassword = getHashedPassword(password, salt);
        System.out.println("Salt: " + salt);
        System.out.println("Hashed password: " + hashedPassword);

        String enteredPassword = "enter password";
        boolean isValid = isValidPassword(enteredPassword, hashedPassword, salt);
        System.out.println("Is valid: " + isValid);
    }

    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    private static String getHashedPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt.getBytes());
        byte[] bytes = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(bytes);
    }

    private static boolean isValidPassword(String enteredPassword, String hashedPassword, String salt) {
        String hashedEnteredPassword = getHashedPassword(enteredPassword, salt);
        return hashedEnteredPassword.equals(hashedPassword);
    }
}