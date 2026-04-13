import java.util.regex.Pattern;

public class java_07043_CredentialValidator_A01 {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.isValidPassword("Password@123")); // Prints: true
        System.out.println(validator.isValidPassword("password")); // Prints: false
    }
}