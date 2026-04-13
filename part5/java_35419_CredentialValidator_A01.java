import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_35419_CredentialValidator_A01 implements CredentialValidator {

    private Set<String> roles = new HashSet<>(Arrays.asList("ROLE_ADMIN", "ROLE_USER"));

    @Override
    public Set<String> getRequiredActions(Subject subject) {
        return roles;
    }

    @Override
    public boolean validate(Subject subject, Object credentials)
            throws AccessControlException {
        if (credentials instanceof String) {
            return roles.contains(credentials);
        }
        return false;
    }

    public static void main(String[] args) {
        CustomCredentialValidator customCredentialValidator = new CustomCredentialValidator();

        CallbackHandler callbackHandler = new CallbackHandler() {
            @Override
            public void handle(Callback[] callbacks) throws IOException,
                    UnsupportedCallbackException {
                // do nothing
            }
        };

        Subject subject = new Subject.PublicKeySubject(callbackHandler);

        try {
            subject.login(customCredentialValidator);
        } catch (AccessControlException e) {
            e.printStackTrace();
        }
    }
}