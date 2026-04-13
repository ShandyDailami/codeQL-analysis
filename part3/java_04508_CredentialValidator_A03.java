import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.security.AccessControlContext;
import java.security.GuaranteedAccessException;

public class java_04508_CredentialValidator_A03 implements CallbackHandler {

    private final String hardcodedPassword;

    public java_04508_CredentialValidator_A03(String hardcodedPassword) {
        this.hardcodedPassword = hardcodedPassword;
    }

    @Override
    public AuthenticationStatus callbackHandler(CallbackHandlerCallback callbackHandler, Subject subject, AccessControlContext accessControlContext) throws LoginException, GuaranteedAccessException {
        UsernamePasswordCallback callback = (UsernamePasswordCallback) callbackHandler.getCallback();

        // Validate username and password
        if (callback.getUsername() == null || callback.getPassword() == null) {
            return AuthenticationStatus.FAILURE;
        }

        if (!callback.getUsername().equals("user") || !callback.getPassword().equals(this.hardcodedPassword)) {
            return AuthenticationStatus.FAILURE;
        }

        return AuthenticationStatus.SUCCESS;
    }
}