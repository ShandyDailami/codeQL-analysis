import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_33886_CredentialValidator_A01 implements CredentialValidator {

    private Set<String> allowedUsernames = new HashSet<>(Arrays.asList("alice", "bob", "charlie"));

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) {
        String username = credential.getIdentifier();
        if (allowedUsernames.contains(username)) {
            return new CredentialValidationResult("Validated successfully", null);
        } else {
            return new CredentialValidationResult("Access Denied", null);
        }
    }

    public static void main(String[] args) throws LoginException, IOException, UnsupportedCallbackException {
        // Create a custom callback handler
        CallbackHandler callbackHandler = new CallbackHandler() {
            @Override
            public CredentialValidationResult getValidationResult(Subject subject, Credential credential) {
                // Always validate successfully
                return new CredentialValidationResult("Success", null);
            }
        };

        // Use the custom credential validator
        CustomCredentialValidator validator = new CustomCredentialValidator();
        Subject subject = Subject.getSubject("unknown");
        Credential credential = new UsernamePasswordCredential("alice", "password");
        subject.login(callbackHandler);

        // Use the custom validator
        CredentialValidator newValidator = new CredentialValidator() {
            @Override
            public CredentialValidationResult validate(Subject subject, Credential credential) {
                // Always validate successfully
                return new CredentialValidationResult("Success", null);
            }
        };

        // Use the new validator
        subject.login(newValidator);
    }
}