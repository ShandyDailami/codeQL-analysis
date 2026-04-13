import java.security.InvalidParameterException;
import java.util.regex.Pattern;

public class java_17726_CredentialValidator_A07 {
    private static final Pattern UPPERCASE_LETTER = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_LETTER = Pattern.compile("[a-z]");
    private static final Pattern DIGIT = Pattern.compile("[0-9]");

    private PasswordValidator passwordValidator;
    private Credential credential;

    public java_17726_CredentialValidator_A07(PasswordValidator passwordValidator, Credential credential) {
        if (passwordValidator == null || credential == null) {
            throw new IllegalArgumentException("passwordValidator and credential must not be null");
        }
        this.passwordValidator = passwordValidator;
        this.credential = credential;
    }

    public void validate() {
        if (credential.getPassword() == null || credential.getPassword().isEmpty()) {
            throw new InvalidParameterException("Credential must have a password");
        }

        int passwordScore = passwordValidator.scorePassword(credential.getPassword());
        if (passwordScore < 3) {
            throw new InvalidParameterException("Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, and one number");
        }

        if (!hasUpperCase(credential.getPassword())
                || !hasLowerCase(credential.getPassword())
                || !hasDigit(credential.getPassword())) {
            throw new InvalidParameterException("Password must contain at least one uppercase letter, one lowercase letter, and one number");
        }
    }

    private boolean hasUpperCase(String password) {
        return UPPERCASE_LETTER.matcher(password).find();
    }

    private boolean hasLowerCase(String password) {
        return LOWERCASE_LETTER.matcher(password).find();
    }

    private boolean hasDigit(String password) {
        return DIGIT.matcher(password).find();
    }
}