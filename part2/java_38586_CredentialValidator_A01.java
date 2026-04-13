import java.security.InvalidParameterException;
import java.util.Base64;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_38586_CredentialValidator_A01 implements CallbackHandler {
    private String username;
    private String password;

    public java_38586_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public CredentialValidationResult validate(Callback[] callbacks) throws LoginException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackPassword = (UsernamePasswordCallback) callback;
                if (!callbackPassword.getIdentifier().equals(this.username)
                        || !this.password.equals(callbackPassword.getPassword())) {
                    throw new InvalidParameterException("Invalid credentials");
                }
            }
        }

        return new CredentialValidationResult("Success", null);
    }
}

public class CustomCredentialValidator implements CredentialValidator {
    @Override
    public boolean validate(CallbackHandler callbackHandler, Map<String, ?> map) throws InvalidParameterException, LoginException {
        return callbackHandler.validate(new Callback[]{new UsernamePasswordCallback("", "")}).isSuccess();
    }
}