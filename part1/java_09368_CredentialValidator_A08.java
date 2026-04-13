import javax.security.auth.Credential;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class java_09368_CredentialValidator_A08 implements CredentialValidator {
    private static final Set<String> AUTHENTICATED_USERS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            "user1", "user2", "user3"
    )));

    @Override
    public boolean validate(Subject subject, Credential credential) {
        return AUTHENTICATED_USERS.contains(credential.getIdentifier());
    }

    @Override
    public boolean getAccessible(Subject subject, Credential credential) {
        return validate(subject, credential);
    }

    @Override
    public boolean seriousValidation(Subject subject, Credential credential) {
        return validate(subject, credential);
    }

    @Override
    public boolean isValidToDomain(Subject subject, Credential credential, String domain) {
        return validate(subject, credential);
    }

    @Override
    public boolean isValidToDelegate(Subject subject, Credential credential, String[] domain) {
        return validate(subject, credential);
    }

    @Override
    public void refresh(Subject subject, Credential credential) {
        // No operation required
    }

    @Override
    public CredentialValidationResult call(String action, Credential credential, CallbackHandler callbackHandler, Object callerContext) throws IOException, UnsupportedCallbackException {
        return CredentialValidationResult.failed();
    }
}