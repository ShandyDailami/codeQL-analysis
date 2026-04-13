import java.security.Mechanism;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Pattern;

import javax.security.auth.Subject;
import javax.security.auth.login.CredentialChangeControl;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_28810_CredentialValidator_A08 implements CredentialValidator {

    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$");

    private SecureRandom random = new SecureRandom();

    @Override
    public boolean validate(Subject subject, Credential credential) throws LoginException {
        String password = credential.getCredential();
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new LoginException("Password does not meet requirements.");
        }
        return true;
    }

    @Override
    public Mechanism getMechanism() {
        return null;
    }

    @Override
    public void reset() {
        // No op
    }

    @Override
    public CredentialChangeControl getCredentialChangeControl() {
        return null;
    }
}