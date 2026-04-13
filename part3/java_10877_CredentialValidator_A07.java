import javax.naming.AuthenticationException;
import javax.security.auth.message.callback.CallbackHandler;
import java.security.Principal;
import java.util.Base64;

public class java_10877_CredentialValidator_A07 implements CredentialValidator {

    private CallbackHandler callbackHandler;
    private String username;
    private String password;

    public java_10877_CredentialValidator_A07(CallbackHandler callbackHandler, String username, String password) {
        this.callbackHandler = callbackHandler;
        this.username = username;
        this.password = password;
    }

    @Override
    public Principal validate(CallbackHandler callbackHandler, String s) throws AuthenticationException {
        String provided = s;
        String expected = Base64.getEncoder().encodeToString(this.password.getBytes());

        if (!provided.equals(expected)) {
            throw new AuthenticationException("Credentials failed to validate.");
        }

        return new Principal(username);
    }
}