import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.AccessControl;
import java.security.GuaranteedAccessException;
import java.security.ProtectionDomain;
import java.security.auth.CredentialException;

public class java_11990_CredentialValidator_A01 implements LoginModule {
    private Subject subject;
    private CallbackHandler callbackHandler;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, ProtectionDomain protectionDomain) throws LoginException {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
    }

    @Override
    public boolean validate(Subject subject, Object credentials) throws CredentialException {
        String input = (String) credentials;

        // Assume we have a hardcoded password
        boolean isValid = input.equals("password");

        // Use the AccessControl API to ensure the access is granted
        if (!isValid) {
            throw new GuaranteedAccessException("Invalid password");
        }

        return isValid;
    }

    @Override
    public boolean commit() throws LoginException {
        // We don't need to do anything in this case
        return true;
    }

    @Override
    public void cleanup() {
        // No cleanup necessary
    }
}