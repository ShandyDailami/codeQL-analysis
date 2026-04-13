import java.util.Base64;
import java.util.regex.Pattern;

public class java_07914_CredentialValidator_A03 {
    // regex pattern to match strong passwords
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    // regex pattern to match strong email addresses
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    // Validate password
    public boolean isPasswordStrong(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    // Validate email
    public boolean isEmailValid(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    // Validate credential (password and email)
    public boolean isValidCredential(String password, String email) {
        return isPasswordStrong(password) && isEmailValid(email);
    }

    // main method
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String password = "Str0ngP@$$w0rd!";
        String email = "test@example.com";
        boolean isValid = validator.isValidCredential(password, email);
        System.out.println("Is Valid: " + isValid);
    }
}