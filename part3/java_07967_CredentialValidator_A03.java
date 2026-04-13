import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;
import java.util.Base64;

public class java_07967_CredentialValidator_A03 {

    private static final MessageDigest digest = MessageDigest.getInstance("SHA-256");

    public static String hashPassword(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }
        return Base64.getEncoder().encodeToString(digest.digest(password.getBytes(StandardCharsets.UTF_8)));
    }

    public static boolean validatePassword(String enteredPassword, String storedPassword) {
        return hashPassword(enteredPassword).equals(storedPassword);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "password";
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed password: " + hashedPassword);

        boolean isValid = validatePassword("password", hashedPassword);
        System.out.println("Password is valid: " + isValid);
    }
}