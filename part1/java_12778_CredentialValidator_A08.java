import java.util.regex.Pattern;

import javax.security.auth.CredentialValidator;
import javax.security.auth.LoginException;
import javax.security.auth.UnknownUserException;
import javax.security.auth.credential.Credential;

public class java_12778_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public String get呼称() {
        return "CustomValidator";
    }

    @Override
    public String get呼称ID() {
        return "CustomValidatorID";
    }

    @Override
    public boolean validate(Credential credential) throws UnknownUserException, LoginException {
        String password = credential.getPassword();

        // Check if password is null or empty
        if (password == null || password.trim().isEmpty()) {
            throw new LoginException("Password cannot be null or empty");
        }

        // Check if password is longer than 8 characters
        if (password.length() <= 8) {
            throw new LoginException("Password must be longer than 8 characters");
        }

        // Check if password contains uppercase, lowercase, digit and special character
        if (!Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%^*?&])[A-Za-z\\d@$!%^*?&]{8,}$", password)) {
            throw new LoginException("Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character");
        }

        return true;
    }

    @Override
    public boolean validate(Credential credential, Object object) throws UnknownUserException, LoginException {
        return false;
    }

    @Override
    public boolean validate(Credential credential, Object object, Object object2) throws UnknownUserException, LoginException {
        return false;
    }
}