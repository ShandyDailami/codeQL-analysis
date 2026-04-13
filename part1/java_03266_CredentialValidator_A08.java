import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_03266_CredentialValidator_A08 {

    public static final String SALT = "Salt";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "password"; // This should be stored in a secure manner
        String hashedPassword = hashPassword(password, SALT);

        String passwordToValidate = "wrongpassword";
        boolean isValid = validatePassword(hashedPassword, passwordToValidate, SALT);
        System.out.println("Password is valid: " + isValid);

        passwordToValidate = "password";
        isValid = validatePassword(hashedPassword, passwordToValidate, SALT);
        System.out.println("Password is valid: " + isValid);
    }

    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        String saltedPassword = salt + password + salt;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(saltedPassword.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    public static boolean validatePassword(String hashedPassword, String password, String salt) throws NoSuchAlgorithmException {
        String saltedPassword = salt + password + salt;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(saltedPassword.getBytes());
        return hashedPassword.equals(Base64.getEncoder().encodeToString(hash));
    }
}