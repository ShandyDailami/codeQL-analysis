import java.util.regex.Pattern;

public class java_21399_CredentialValidator_A07 {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public boolean isPasswordStrong(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.isPasswordStrong("Password1")); // Outputs: false
        System.out.println(validator.isPasswordStrong("Password1@")); // Outputs: false
        System.out.println(validator.isPasswordStrong("Password1@abc")); // Outputs: false
        System.out.println(validator.isPasswordStrong("Password1@abc1")); // Outputs: true
    }
}