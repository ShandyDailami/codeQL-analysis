import java.security.InvalidParameterException;
import java.util.Base64;

public class java_39244_CredentialValidator_A03 implements CredentialValidator {
    // The only way to ensure security is by not doing anything unnecessarily.
    // Also, we're assuming that the passwords are Base64-encoded.
    private static final String PASSWORD_MAGIC = "PASSWORD_MAGIC_STRING_HERE";

    @Override
    public boolean validate(String user, String password) throws InvalidParameterException {
        // The password must be Base64-encoded.
        if (password.startsWith(PASSWORD_MAGIC)) {
            password = password.substring(PASSWORD_MAGIC.length());
        } else {
            throw new InvalidParameterException("Invalid password encoding.");
        }

        // We're assuming that the password is always a single word.
        if (password.length() > 8) {
            throw new InvalidParameterException("Password too long.");
        }

        // Verify the password.
        // In a real system, you would compare the password against a database hash.
        // We're just checking if the password is correct.
        if (!password.equals("correct_password")) {
            throw new InvalidParameterException("Invalid password.");
        }

        return true;
    }
}