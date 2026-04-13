// import necessary libraries
import java.util.regex.Pattern;

// define the CredentialValidator interface
public interface CredentialValidator {
    boolean isValidUsername(String username);
    boolean isValidPassword(String password);
    boolean areValidCredentials(String username, String password);
}

// implement the CredentialValidator interface
public class java_24614_CredentialValidator_A01 implements CredentialValidator {
    private static final Pattern VALID_USERNAME_PATTERN = Pattern.compile("[a-zA-Z0-9]+");
    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9]{8,}");

    @Override
    public boolean isValidUsername(String username) {
        return VALID_USERNAME_PATTERN.matcher(username).matches();
    }

    @Override
    public boolean isValidPassword(String password) {
        return VALID_PASSWORD_PATTERN.matcher(password).matches();
    }

    @Override
    public boolean areValidCredentials(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}

// main program
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidatorImpl();

        // test valid credentials
        System.out.println(validator.areValidCredentials("user1", "password1")); // should print true
        System.out.println(validator.areValidCredentials("invalid", "password1")); // should print false
        System.out.println(validator.areValidCredentials("user1", "12345678")); // should print false
    }
}