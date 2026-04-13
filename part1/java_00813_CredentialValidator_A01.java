import java.util.regex.Pattern;

import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;

public class java_00813_CredentialValidator_A01 implements CredentialValidator {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    @Override
    public String validate(String arg0) throws CredentialException, InvalidCredentialException {
        if (!pattern.matcher(arg0).matches()) {
            throw new InvalidCredentialException("Password does not match the required pattern");
        }
        return arg0;
    }

    @Override
    public boolean validate(Credential credential) throws CredentialException, InvalidCredentialException {
        return validate(credential.getCredentialIdentifier());
    }
}