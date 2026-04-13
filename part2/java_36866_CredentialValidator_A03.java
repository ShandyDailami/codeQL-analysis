import java.util.regex.Pattern;

public class java_36866_CredentialValidator_A03 {
    private static final Pattern VALID_USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]{3,20}$");
    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=.{8,})");

    public boolean isValidUsername(String username) {
        return VALID_USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean isValidPassword(String password) {
        return VALID_PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean validateCredentials(String username, String password) {
        if (!isValidUsername(username)) {
            System.out.println("Invalid username. It must contain only letters, numbers, dots, underscores, percent signs, plus signs and hyphens. It must be between 3 and 20 characters long.");
            return false;
        }

        if (!isValidPassword(password)) {
            System.out.println("Invalid password. It must contain at least one uppercase letter, one lowercase letter, one number and one special character. It must be at least 8 characters long.");
            return false;
        }

        System.out.println("Credentials are valid.");
        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validateCredentials("user", "password");
        validator.validateCredentials("user123", "password");
        validator.validateCredentials("user123@", "password");
        validator.validateCredentials("user123@abc", "password");
        validator.validateCredentials("user123@abc", "passwor");
        validator.validateCredentials("user123@abc", "passwor123");
    }
}