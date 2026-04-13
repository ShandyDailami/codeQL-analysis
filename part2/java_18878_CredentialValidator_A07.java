import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

public class java_18878_CredentialValidator_A07 implements CredentialValidator {

    // List of allowed passwords
    private static final List<String> ALLOWED_PASSWORDS = Arrays.asList("password1", "password2", "password3");

    @Override
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        // Return true if password is in the allowed list
        return ALLOWED_PASSWORDS.contains(password);
    }
}