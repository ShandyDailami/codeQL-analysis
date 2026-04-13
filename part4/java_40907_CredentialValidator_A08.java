import java.util.regex.Pattern;

public class java_40907_CredentialValidator_A08 {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9]{4,16}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^.{8,}$");

    public boolean validateUsername(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean validatePassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean validateCredentials(String username, String password) {
        return validateUsername(username) && validatePassword(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println("Valid username: " + validator.validateUsername("validUsername"));
        System.out.println("Valid password: " + validator.validatePassword("validPassword"));
        System.out.println("Valid credentials: " + validator.validateCredentials("validUsername", "validPassword"));

        System.out.println("Invalid username: " + validator.validateUsername("invalidUsername"));
        System.out.println("Invalid password: " + validator.validatePassword("invalidPassword"));
        System.out.println("Invalid credentials: " + validator.validateCredentials("invalidUsername", "invalidPassword"));
    }
}