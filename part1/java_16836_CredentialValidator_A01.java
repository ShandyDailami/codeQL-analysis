import java.util.regex.Pattern;

public class java_16836_CredentialValidator_A01 {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@$!%^*?&])[A-Za-z0-9@$!%^*?&]{8,}$");

    public boolean isPasswordStrong(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Strong password
        System.out.println(validator.isPasswordStrong("StrongPassword@123")); // should return true

        // Weak password
        System.out.println(validator.isPasswordStrong("weakpassword")); // should return false
    }
}