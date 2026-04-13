import java.util.HashSet;
import java.util.Set;

import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_36559_CredentialValidator_A07 implements CredentialValidator {

    private Set<String> knownPasswords = new HashSet<>();

    public java_36559_CredentialValidator_A07() {
        knownPasswords.add("password1");
        knownPasswords.add("password2");
        knownPasswords.add("password3");
        // ... add more passwords as needed
    }

    @Override
    public CredentialValidationResult validate(Credential c) throws LoginException {
        String password = c.getPassword();
        if (knownPasswords.contains(password)) {
            return CredentialValidationResult.VALID;
        } else {
            return CredentialValidationResult.INVALID;
        }
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        // No callbacks, so we can return null
        return null;
    }
}