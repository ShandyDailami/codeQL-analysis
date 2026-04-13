import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.realm.Realm;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_18051_CredentialValidator_A07 implements Realm {

    private Set<String> usernames = new HashSet<>(Arrays.asList("user1", "user2", "user3"));
    private Set<String> passwords = new HashSet<>(Arrays.asList("pass1", "pass2", "pass3"));

    @Override
    public String getName() {
        return "CustomRealm";
    }

    @Override
    public String getObjectClassName() {
        return null;
    }

    @Override
    public String getAlgorithmName() {
        return null;
    }

    @Override
    public String getRealmName() {
        return "CustomRealm";
    }

    @Override
    public boolean validate(Credential c) throws IOException, UnsupportedCallbackException {
        String user = c.getIdentifier();
        CredentialValidationResult result = null;

        if (user != null && !"".equals(user)) {
            String password = c.getCredential();
            if (passwords.contains(password)) {
                result = CredentialValidationResult.success();
            } else {
                result = CredentialValidationResult.failed();
            }
        } else {
            result = CredentialValidationResult.failed();
        }

        return result.isCommandSupported(CredentialValidationResult.COMMAND_STOP_SESSION);
    }

    @Override
    public boolean refresh(Callback callback) throws IOException, UnsupportedCallbackException {
        return false;
    }
}