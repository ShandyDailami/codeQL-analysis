import java.util.regex.Pattern;

public class java_10319_CredentialValidator_A03 {

    // Checking if password is strong enough
    private static final Pattern STRONG_PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[0-9a-zA-Z@#$%^&*]{8,}$");

    public boolean isPasswordStrong(String password) {
        return STRONG_PASSWORD_PATTERN.matcher(password).matches();
    }

    // Usage
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.isPasswordStrong("StrongPassword@123")); // Returns true
        System.out.println(validator.isPasswordStrong("WeakPassword")); // Returns false
    }
}