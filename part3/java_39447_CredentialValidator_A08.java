import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_39447_CredentialValidator_A08 implements CredentialValidator {

    private Set<String> knownDomains;
    private Set<String> knownUsernames;
    private boolean forceCredentialPresent = false;

    public java_39447_CredentialValidator_A08() {
        knownDomains = new HashSet<>(Arrays.asList("example.com", "test.com"));
        knownUsernames = new HashSet<>(Arrays.asList("alice", "bob"));
    }

    @Override
    public boolean validate(Subject subject, CallbackHandler callbackHandler,
                           String targetHost, String targetUser)
            throws IOException, LoginException {

        // Check if targetHost is in knownDomains
        if (!knownDomains.contains(targetHost)) {
            return false;
        }

        // Check if targetUser is in knownUsernames
        if (!knownUsernames.contains(targetUser)) {
            return false;
        }

        // If all checks pass, return true
        return true;
    }

    @Override
    public boolean getCredentialPresent() {
        return forceCredentialPresent;
    }

    @Override
    public boolean setCredentialPresent(boolean present) {
        forceCredentialPresent = present;
        return present;
    }

    @Override
    public boolean getForceCredentialPresent() {
        return forceCredentialPresent;
    }

    @Override
    public boolean setForceCredentialPresent(boolean present) {
        forceCredentialPresent = present;
        return present;
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return null;
    }

    @Override
    public boolean hasCallbackHandler() {
        return false;
    }

    @Override
    public Set<String> getAcceptedPasswordTypes() {
        return null;
    }

    @Override
    public Set<String> getAcceptedUsernameTypes() {
        return null;
    }
}