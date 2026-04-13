import java.security.InvalidParameterException;
import java.util.regex.Pattern;

import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_13414_CredentialValidator_A07 implements CredentialValidator {

    private static final Pattern STRONG_PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^\\w\\s:])(?=.{8,})");
    private static final Pattern WEAK_PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})");

    private boolean strength = true; // true = strong, false = weak

    public java_13414_CredentialValidator_A07(boolean strength) {
        this.strength = strength;
    }

    @Override
    public String validate(Credential credential) throws LoginException {
        String password = (String) credential.getCredential();
        if (strength) {
            if (!STRONG_PASSWORD_PATTERN.matcher(password).matches()) {
                throw new InvalidParameterException("Strong password must contain at least one lowercase letter, one uppercase letter, one numeric character, and one special character and must be at least 8 characters long");
            }
        } else {
            if (!WEAK_PASSWORD_PATTERN.matcher(password).matches()) {
                throw new InvalidParameterException("Weak password must contain at least one lowercase letter, one uppercase letter, one numeric character and must be at least 8 characters long");
            }
        }
        return null; // or a specific message indicating the password is strong or weak
    }

}