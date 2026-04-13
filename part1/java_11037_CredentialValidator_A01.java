import java.util.regex.Pattern;

import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.realm.Realm;

public class java_11037_CredentialValidator_A01 implements Realm, CredentialValidationResult.Status {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");

    @Override
    public String getName() {
        return "CustomRealm";
    }

    @Override
    public boolean validate(Credential credential) {
        String password = credential.getCredentialIdentifier();
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    @Override
    public void refresh() {
        // No-op
    }

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler, Credential credential)
            throws UnsupportedCallbackException {
        Credential c = credential;
        Callback callback = callbackHandler.getCallback();
        if (callback != null) {
            try {
                callback.checkPostCondition(c);
                return new CredentialValidationResult("Success", "A01_BrokenAccessControl", "A01_BrokenAccessControl");
            } catch (Exception e) {
                return new CredentialValidationResult("Failure", "A01_BrokenAccessControl", e.getMessage());
            }
        } else {
            return new CredentialValidationResult("Failure", "A01_BrokenAccessControl", "No callback provided");
        }
    }
}