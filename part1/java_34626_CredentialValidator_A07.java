import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_34626_CredentialValidator_A07 {

    // A password is considered strong if it has a length greater than 8 and contains a mix of uppercase and lowercase letters,
    // numbers and special characters.
    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean isPasswordStrong(String password) {
        return password.matches(STRONG_PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        PasswordManager passwordManager = new PasswordManager();

        String password = "ThisIsMyPassword";

        if (passwordManager.isPasswordStrong(password)) {
            System.out.println("Password is strong");
        } else {
            System.out.println("Password is weak");
        }
    }
}