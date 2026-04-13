import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_12883_CredentialValidator_A03 implements CredentialValidator {

    private Map<String, String> credentials = new HashMap<>();

    public java_12883_CredentialValidator_A03() {
        credentials.put("user", Base64.getEncoder().encodeToString("user:password".getBytes()));
    }

    @Override
    public void validate(CallbackHandler callbackHandler) throws IOException, UnsupportedCallbackException {
        callbackHandler.handle(new Callback[]{
                new UsernameCallback("Username: "),
                new PasswordCallback("Password: ", false)
        });

        String providedUsername = ((UsernameCallback) callbacks[0]).getResult();
        String providedPassword = new String(Base64.getDecoder().decode(callbacks[1].getInput(providedUsername.length())));

        if (providedUsername == null || providedPassword == null) {
            throw new IllegalArgumentException("Username or password not provided in callback");
        }

        String expectedUsername = credentials.keySet().iterator().next();
        String expectedPassword = credentials.get(expectedUsername);

        if (!providedUsername.equals(expectedUsername) || !providedPassword.equals(expectedPassword)) {
            throw new AuthenticationFailedException("Invalid credentials");
        }
    }

    private static class UsernameCallback extends LoginModuleRequiredCallback
    {
        public java_12883_CredentialValidator_A03(String prompt) {
            super(prompt);
        }
    }

    private static class PasswordCallback extends LoginModuleRequiredCallback
    {
        public java_12883_CredentialValidator_A03(String prompt, boolean echoOn) {
            super(prompt, echoOn);
        }
    }
}