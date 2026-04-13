import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.UsernamePasswordAuthenticationModule;
import java.io.IOException;
import java.util.Base64;

public class java_07037_CredentialValidator_A03 extends UsernamePasswordAuthenticationModule {

    private static final String AUTHENTICATED_USER = "user";

    @Override
    public boolean validate(Subject subject, Object credentials) {
        String providedCredentials = new String((byte[]) credentials);
        String expectedCredentials = AUTHENTICATED_USER;
        return providedCredentials.equals(expectedCredentials);
    }

    @Override
    public boolean supports(CallbackHandler callbackHandler) {
        return true;
    }

    @Override
    public boolean supports(Callback callback) {
        return true;
    }

    @Override
    public boolean verify() throws IOException {
        return true;
    }
}

public class TestCredentialValidator {
    public static void main(String[] args) {
        CredentialValidatorValidator validator = new CredentialValidatorValidator();
        CredentialValidatorModule credentialValidatorModule = new CredentialValidatorModule();
        validator.getState().setCredentialValidator(credentialValidatorModule);
        // Now we can use the validator.
    }
}