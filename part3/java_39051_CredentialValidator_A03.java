import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.login.CredentialException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_39051_CredentialValidator_A03 implements CredentialValidator {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("[0-9]");
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile("[a-z]");
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[@#$%^&+=!]");

    @Override
    public boolean validate(Credential credential) throws CredentialException {
        String password = credential.getPassword();
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        if (!matcher.matches()) {
            throw new PasswordChangeException("Password does not match the required pattern");
        }

        if (password.length() < 8) {
            throw new PasswordChangeException("Password length must be at least 8 characters");
        }

        if (!DIGIT_PATTERN.matcher(password).find()) {
            throw new PasswordChangeException("Password must contain at least one digit");
        }

        if (!UPPERCASE_PATTERN.matcher(password).find()) {
            throw new PasswordChangeException("Password must contain at least one uppercase letter");
        }

        if (!LOWERCASE_PATTERN.matcher(password).find()) {
            throw new PasswordChangeException("Password must contain at least one lowercase letter");
        }

        if (!SPECIAL_CHAR_PATTERN.matcher(password).find()) {
            throw new PasswordChangeException("Password must contain at least one special character");
        }

        return true;
    }
}