import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_00264_CredentialValidator_A03 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    // This is a simple way to hash a password.
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // This method will attempt to authenticate the provided username and password.
    public boolean validateCredentials(String username, String password) {
        return username.equals(USERNAME) && hashPassword(password).equals(PASSWORD);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validateCredentials("user", "password");
        System.out.println("Is valid: " + isValid);
    }
}