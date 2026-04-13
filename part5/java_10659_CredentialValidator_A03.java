import java.security.GeneralSecurityException;
import java.util.regex.Pattern;

public class java_10659_CredentialValidator_A03 {
    private static final Pattern UPPERCASE_LETTER = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_LETTER = Pattern.compile("[a-z]");
    private static final Pattern DIGIT = Pattern.compile("[0-9]");
    private static final Pattern SPECIAL_CHARACTER = Pattern.compile("[~ûéêîôàïùäëïöüéêîôàïùäëïöüéêîôàïù]");

    public boolean validatePassword(String password) throws GeneralSecurityException {
        if (password == null) {
            throw new GeneralSecurityException("Password cannot be null");
        }

        if (password.length() < 8) {
            throw new GeneralSecurityException("Password must be at least 8 characters long");
        }

        if (!UPPERCASE_LETTER.matcher(password).find()) {
            throw new GeneralSecurityException("Password must contain at least one uppercase letter");
        }

        if (!LOWERCASE_LETTER.matcher(password).find()) {
            throw new GeneralSecurityException("Password must contain at least one lowercase letter");
        }

        if (!DIGIT.matcher(password).find()) {
            throw new GeneralSecurityException("Password must contain at least one digit");
        }

        if (!SPECIAL_CHARACTER.matcher(password).find()) {
            throw new GeneralSecurityException("Password must contain at least one special character [~ûéêîôàïùäëïöüéêîôàïùäëïöüéêîôàïù]");
        }

        return true;
    }
}