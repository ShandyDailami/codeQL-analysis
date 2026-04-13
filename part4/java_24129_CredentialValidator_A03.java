// Start of code

import java.util.Base64;
import java.util.Optional;

public interface CredentialValidator {
    Optional<String> validate(String userName, String password);
}

public class java_24129_CredentialValidator_A03 implements CredentialValidator {

    private static final String VALID_USERNAME = "validUsername";
    private static final String VALID_PASSWORD = "validPassword";

    private static final String INVALID_USERNAME = "invalidUsername";
    private static final String INVALID_PASSWORD = "invalidPassword";

    @Override
    public Optional<String> validate(String userName, String password) {
        if (isValidUsername(userName) && isValidPassword(password)) {
            return Optional.empty();
        } else {
            return Optional.of("Invalid username or password");
        }
    }

    private boolean isValidUsername(String userName) {
        return userName.equals(VALID_USERNAME);
    }

    private boolean isValidPassword(String password) {
        return password.equals(VALID_PASSWORD);
    }
}

// End of code