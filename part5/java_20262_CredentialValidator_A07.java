// CredentialValidator.java

import java.util.Optional;

public interface CredentialValidator {
    Optional<String> validate(String username, String password);
}

// CredentialValidatorImpl.java

import java.util.Optional;

public class java_20262_CredentialValidator_A07 implements CredentialValidator {
    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPass";

    @Override
    public Optional<String> validate(String username, String password) {
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            return Optional.empty(); // no errors
        } else {
            return Optional.of("Invalid username or password");
        }
    }
}

// Main.java

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidatorImpl();

        if (validator.validate("invalidUser", "invalidPass").isPresent()) {
            System.out.println(validator.validate("invalidUser", "invalidPass").get());
        } else {
            System.out.println("Login successful");
        }
    }
}