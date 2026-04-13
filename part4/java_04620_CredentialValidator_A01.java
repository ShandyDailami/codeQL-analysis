import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;

public class java_04620_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public String validate(String arg0) throws InvalidCredentialException {
        String password = arg0;
        
        // Check if the password has a digit
        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher matcher = digitPattern.matcher(password);
        if (!matcher.find()) {
            throw new InvalidCredentialException("Password must contain at least one digit");
        }

        // Check if the password has a special character
        digitPattern = Pattern.compile("[^a-zA-Z]");
        matcher = digitPattern.matcher(password);
        if (!matcher.find()) {
            throw new InvalidCredentialException("Password must contain at least one special character");
        }

        // Check if the password is at least 8 characters long
        if (password.length() < 8) {
            throw new InvalidCredentialException("Password must be at least 8 characters long");
        }

        // All checks passed, return the password
        return password;
    }

    @Override
    public boolean validate(Credential credential) throws InvalidCredentialException {
        return validate(credential.getPassword());
    }
}