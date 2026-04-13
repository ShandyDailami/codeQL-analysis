import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_19744_CredentialValidator_A08 {

    private static final String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    private java_19744_CredentialValidator_A08() {}

    public static boolean validateCredentials(String password) {
        if (password == null) {
            return false;
        }

        boolean validPassword = password.matches(PATTERN);

        // We can't really validate the password here, only if it's validated by another component
        return validPassword;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Encoding the password
        String password = "SecurePassword@123";
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // Validating the password
        if (validateCredentials(encodedPassword)) {
            System.out.println("Password is validated successfully");
        } else {
            System.out.println("Password is not validated successfully");
        }
    }
}