import java.util.regex.Pattern;

public class java_24392_CredentialValidator_A08 {

    // A strong password must contain at least one uppercase letter, one lowercase letter, one number
    // and one special character.
    private static final Pattern STRONG_PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).+$");

    public boolean isPasswordStrong(String password) {
        return STRONG_PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        PasswordValidator passwordValidator = new PasswordValidator();

        // Test passwords that are not strong enough
        String[] weakPasswords = {"abc", "123", "ABC", "123$", "abc123$"};
        for (String password : weakPasswords) {
            if (passwordValidator.isPasswordStrong(password)) {
                System.out.println("Password '" + password + "' is weak enough.");
            } else {
                System.out.println("Password '" + password + "' is not weak enough.");
            }
        }

        // Test passwords that are strong enough
        String[] strongPasswords = {"abc$123", "ABC123$", "abc123$abc", "abc123$ABC"};
        for (String password : strongPasswords) {
            if (!passwordValidator.isPasswordStrong(password)) {
                System.out.println("Password '" + password + "' is not weak enough.");
            } else {
                System.out.println("Password '" + password + "' is strong enough.");
            }
        }
    }
}