import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_35806_CredentialValidator_A03 {

    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])[a-zA-Z0-9!@#\$%\^&\*]{8,}$";

    public boolean isPasswordStrong(String password) {
        return password.matches(STRONG_PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String strongPassword = "Password@123";
        String weakPassword = "Passw";

        System.out.println("Is strong password: " + validator.isPasswordStrong(strongPassword));
        System.out.println("Is weak password: " + validator.isPasswordStrong(weakPassword));
    }
}