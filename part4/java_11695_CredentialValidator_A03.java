import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_11695_CredentialValidator_A03 {
    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean isPasswordStrong(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password must not be null");
        }
        return password.matches(STRONG_PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.isPasswordStrong("StrongPassword@")); // should return true
        System.out.println(validator.isPasswordStrong("WeakPassword")); // should return false
    }
}