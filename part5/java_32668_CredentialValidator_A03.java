import java.util.regex.Pattern;

public class java_32668_CredentialValidator_A03 {
    // regular expression for password validation
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    public boolean isPasswordStrong(String password) {
        return Pattern.matches(PASSWORD_PATTERN, password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String strongPassword = "Password@123";
        String weakPassword = "pass";

        System.out.println(validator.isPasswordStrong(strongPassword)
                ? "Strong Password"
                : "Weak Password");

        System.out.println(validator.isPasswordStrong(weakPassword)
                ? "Strong Password"
                : "Weak Password");
    }
}