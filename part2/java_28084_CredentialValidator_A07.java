import java.util.Arrays;
import java.util.List;

public class java_28084_CredentialValidator_A07 {
    // Hardcoded list of valid passwords
    private static final List<String> VALID_PASSWORDS = Arrays.asList("password", "secret", "qwerty", "admin", "123456");

    public boolean validate(String password) {
        return VALID_PASSWORDS.contains(password);
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();

        // Password to validate
        String passwordToValidate = "qwerty";

        if (validator.validate(passwordToValidate)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }
}