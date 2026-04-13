import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlContext;
import java.security.AccessControlListener;
import java.security.GuardianInfo;
import java.security.GuardianInfoListener;
import java.security.GuardianInfoService;
import java.security.GuardianInfoServiceException;
import java.util.HashSet;
import java.util.Set;

public class java_32496_CredentialValidator_A07 implements CallbackHandler, GuardianInfoService, AccessControlListener, GuardianInfoListener {

    private Set<String> users = new HashSet<>();
    private Set<String> passwords = new HashSet<>();

    public java_32496_CredentialValidator_A07() {
        users.add("user1");
        users.add("user2");

        passwords.add("password1");
        passwords.add("password2");
    }

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException, IOException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackToUse = (UsernamePasswordCallback) callback;
                callbackToUse.setRequestedPassword("");
            }
        }
    }

    @Override
    public Set<GuardianInfo> getGuardianInfos(AccessControlContext context) throws SecurityException {
        return null;
    }

    @Override
    public Set<String> getAcceptedPasswordList(AccessControlContext context) throws IOException, SecurityException {
        return passwords;
    }

    @Override
    public Set<String> getAcceptedUsernameList(AccessControlContext context) throws IOException, SecurityException {
        return users;
    }

    @Override
    public String[] getClassNames() throws IOException, SecurityException {
        return new String[0];
    }

    @Override
    public void refresh() throws IOException, SecurityException {
    }

    @Override
    public void accessAccepted(AccessControlContext context) throws SecurityException {
    }

    @Override
    public void accessDenied(AccessControlContext context) throws SecurityException {
    }
}