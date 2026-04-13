import java.util.regex.Pattern;

public class java_35449_CredentialValidator_A01 {

    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,}$");

    public boolean isPasswordStrong(String password) {
        return passwordPattern.matcher(password).matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test passwords
        System.out.println(validator.isPasswordStrong("password"));  // false
        System.out.println(validator.isPasswordStrong("Password1"));  // false
        System.out.println(validator.isPasswordStrong("Password1@"));  // false
        System.out.println(validator.isPasswordStrong("Password1@#"));  // false
        System.out.println(validator.isPasswordStrong("Password1@#$"));  // true
    }
}