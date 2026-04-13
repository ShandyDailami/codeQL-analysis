import java.util.regex.Pattern;

public class java_05691_CredentialValidator_A08 {
    // A regular expression for a password that is at least 8 characters, contains a special character, and ends with a number.
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,}$");

    public boolean validate(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test with valid password
        System.out.println(validator.validate("Password@123")); // true

        // Test with invalid password
        System.out.println(validator.validate("password")); // false
    }
}