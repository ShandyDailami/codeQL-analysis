import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_17855_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public String validate(String credentialId) throws CredentialException {
        return validatePassword(credentialId);
    }

    private String validatePassword(String password) {
        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            throw new InvalidCredentialException("Password must be at least 8 characters long");
        }

        // Check if password contains at least one uppercase letter, one lowercase letter, and one number
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).+$");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new InvalidCredentialException("Password must contain at least one uppercase letter, one lowercase letter, and one number");
        }

        // If password is valid, return null
        return null;
    }
}