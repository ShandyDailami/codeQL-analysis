import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.auth.SubjectCredentialStore;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_02740_CredentialValidator_A08 implements CallbackHandler {

    private final Set<String> supportedCredentials = new HashSet<>(Arrays.asList("MD5", "SHA1", "SHA256", "SHA384", "SHA512"));

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException, AccessControlException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackToUse = (UsernamePasswordCallback) callback;
                callbackToUse.setPasswordText("<Password>");
                String userName = callbackToUse.getIdentifier();
                callbackToUse.setRequestedAuthentication(userName);
                callbackToUse.setRequestorPrincipal(Subject.getDefaultSubject().getPrincipal());
                if (!supportedCredentials.contains(callbackToUse.getHashAlgName())) {
                    throw new UnsupportedCallbackException(new String[]{callbackToUse.getHashAlgName()}, "Unsupported Credential type");
                }
            }
        }
    }
}