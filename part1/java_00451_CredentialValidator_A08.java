import java.util.regex.Pattern;

import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.LoginException;

public class java_00451_CredentialValidator_A08 implements CredentialValidator {

    private static final Pattern UPPERCASE = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE = Pattern.compile("[a-z]");
    private static final Pattern NUMBER = Pattern.compile("[0-9]");
    private static final Pattern SPECIAL_CHAR = Pattern.compile("[^a-zA-Z0-9]");
    private static final Pattern LENGTH = Pattern.compile("^.{8,}$");

    @Override
    public CredentialValidatorResult validate(javax.security.auth.Credential credential) {
        String password = credential.getCredential();
        if (!LENGTH.matcher(password).matches()) {
            throw new LoginException("Password length must be at least 8 characters long");
        }
        if (!UPPERCASE.matcher(password).find()) {
            throw new LoginException("Password must contain at least one upper case letter");
        }
        if (!LOWERCASE.matcher(password).find()) {
            throw new LoginException("Password must contain at least one lower case letter");
        }
        if (!NUMBER.matcher(password).find()) {
            throw new LoginException("Password must contain at least one numeric character");
        }
        if (!SPECIAL_CHAR.matcher(password).find()) {
            throw new LoginException("Password must contain at least one special character");
        }
        return CredentialValidatorResult.success();
    }
}