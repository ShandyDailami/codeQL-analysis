import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_38458_CredentialValidator_A03 implements CallbackHandler {

    private List<String> usernames = new ArrayList<>();
    private List<String> passwords = new ArrayList<>();

    public java_38458_CredentialValidator_A03() {
        usernames.add("user1");
        usernames.add("user2");
        passwords.add("password1");
        passwords.add("password2");
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernameCallback) {
                UsernameCallback cb = (UsernameCallback) callback;
                cb.setRequested(usernames.toArray(new String[0]));
            } else if (callback instanceof PasswordCallback) {
                PasswordCallback cb = (PasswordCallback) callback;
                cb.setRequested(passwords.toArray(new String[0]));
            }
        }
    }
}

public class CustomCredentialProvider extends javax.security.auth.credential.CredentialProvider {

    @Override
    public List<String> getSupportedCredentialIds() {
        return List.of("custom");
    }

    @Override
    public List<String> getSupportedPrincipals() {
        return List.of("user1", "user2");
    }

    @Override
    public CredentialValidationResult validate(Credential credential) {
        UsernamePasswordCredential userCredential = (UsernamePasswordCredential) credential;
        String presentedPassword = userCredential.getPassword();

        if (userCredential.getIdentifier().equals("user1") && presentedPassword.equals("password1")) {
            return new CredentialValidationResult("Success", null);
        } else if (userCredential.getIdentifier().equals("user2") && presentedPassword.equals("password2")) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", null);
        }
    }

    @Override
    public CredentialValidationResult validate(Credential credential, String callingPrincipal) throws CredentialValidationException {
        return validate(credential);
    }

    @Override
    public CredentialValidationResult validate(Credential credential, String callingPrincipal, String callingAuthenticationMechanism) throws CredentialValidationException {
        return validate(credential);
    }
}