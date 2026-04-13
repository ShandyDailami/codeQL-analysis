import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.GuardianInfo;
import java.security.GuardianInfoService;
import java.security.GuardianInfoServiceException;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_10177_CredentialValidator_A03 implements CredentialValidator {

    private String username;

    public java_10177_CredentialValidator_A03(String username) {
        this.username = username;
    }

    public Set<String> getAcceptedPasswordTypes() {
        return new HashSet<>(Arrays.asList("Password", "Password1"));
    }

    public Set<String> getAcceptedUsernameTypes() {
        return new HashSet<>(Arrays.asList("Username", "Username1"));
    }

    public boolean validate(Subject subject, Object credentials)
            throws AccessControlException {

        String providedUsername = (String) credentials;
        return this.username.equals(providedUsername);
    }

    public boolean getGuardianInfo(GuardianInfoService guardianInfoService,
            ProtectionDomain protectionDomain,
            GuardianInfo guardianInfo) throws GuardianInfoServiceException,
            IOException {

        guardianInfo.setGuardianType("Password", this.username);
        return true;
    }

    public void afterInvocation(Subject subject, Object credentials,
            CallbackHandler callbackHandler, CredentialAccess control)
            throws IOException, UnsupportedCallbackException,
            AccessControlException {
        callbackHandler.handle(new Callback[]{ new UsernamePasswordCallback("", "") });
    }
}