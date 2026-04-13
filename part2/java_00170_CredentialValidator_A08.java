import java.util.regex.Pattern;

public class java_00170_CredentialValidator_A08 {
    private static final Pattern PASSWORD_PATTERN = 
        Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%^*?&])[A-Za-z0-9@$!%^*?&]{8,}$");

    public boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String validPassword = "Password@123";
        System.out.println(validator.isValidPassword(validPassword) ? "Valid" : "Invalid");

        String weakPassword = "pass";
        System.out.println(validator.isValidPassword(weakPassword) ? "Valid" : "Invalid");
    }
}