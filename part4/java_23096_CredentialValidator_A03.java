import java.util.regex.Pattern;

public class java_23096_CredentialValidator_A03 {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,}$");

    public boolean isValidUsername(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean validate(String username, String password) {
        if (!isValidUsername(username)) {
            System.out.println("Invalid username");
            return false;
        }

        if (!isValidPassword(password)) {
            System.out.println("Invalid password");
            return false;
        }

        System.out.println("Credentials are valid");
        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("testuser", "Test@1234");
    }
}