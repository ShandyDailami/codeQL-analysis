import java.util.regex.Pattern;

public class java_15525_CredentialValidator_A07 {
    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public boolean isPasswordStrong(String password) {
        return passwordPattern.matcher(password).matches();
    }

    public static void main(String[] args) {
        StrongPasswordValidator validator = new StrongPasswordValidator();

        System.out.println(validator.isPasswordStrong("Password123")); // Outputs: true
        System.out.println(validator.isPasswordStrong("password")); // Outputs: false
    }
}