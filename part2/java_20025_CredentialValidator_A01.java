import java.util.regex.Pattern;

public class java_20025_CredentialValidator_A01 {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*])[A-Za-z0-9@#$%^&*]{8,}$");

    public boolean isPasswordStrong(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();

        // Testing with strong password
        String strongPassword = "ThisIsAStongPassword1!";
        System.out.println(validator.isPasswordStrong(strongPassword)); // Expected output: true

        // Testing with weak password
        String weakPassword = "weakpassword";
        System.out.println(validator.isPasswordStrong(weakPassword)); // Expected output: false
    }
}