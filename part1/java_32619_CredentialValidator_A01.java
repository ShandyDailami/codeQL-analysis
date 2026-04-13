// Start of code

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlAction;
import java.security.AccessControlException;
import java.security.GuaranteedAccessControl;
import java.security.GuaranteedAccessControl.Action;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_32619_CredentialValidator_A01 implements CallbackHandler {
    private Set<String> credentials = new HashSet<>(Arrays.asList("user1", "user2", "user3"));

    @Override
    public void handle(Callback callback) throws IOException, AccessControlException {
        Subject subject = (Subject) callback.getSubject();
        String callerPrincipal = subject.getPrincipal().toString();
        if (credentials.contains(callerPrincipal)) {
            subject.getPrincipals().add(new org.jboss.security.auth.spi.UsernamePasswordCredential(callerPrincipal));
            subject.removeGrantedAuthority("role1");
            subject.addGrantedAuthority("role2");
        } else {
            throw new AccessControlException("Access to resource is denied");
        }
    }
}

public class MyGuaranteedAccessControl implements GuaranteedAccessControl {
    @Override
    public AccessControlAction accessControl(Subject subject, Object object, String operation) throws AccessControlException {
        if (object.equals("resource")) {
            if (operation.equals("read")) {
                return AccessControlAction.permit();
            } else if (operation.equals("write")) {
                return AccessControlAction.permit();
            } else {
                return AccessControlAction.defend();
            }
        } else {
            return AccessControlAction.defend();
        }
    }
}

// End of code