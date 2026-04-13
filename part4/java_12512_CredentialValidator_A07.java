import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.security.AccessControlAction;
import java.security.AccessControlListener;
import java.security.GuardianInfo;
import java.security.GuardianInfoService;
import java.security.GuardianInfoServiceException;
import java.security.GuardianNotFoundException;
import java.security.GuardianPermissionEntry;
import java.security.GuardianPermissionEntryList;
import java.security.GuardianPermissionEntryService;
import java.security.GuardianPermissionEntryServiceException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class java_12512_CredentialValidator_A07 implements CredentialValidator {

    private Set<String> authenticatedUsers;

    public java_12512_CredentialValidator_A07() {
        this.authenticatedUsers = Collections.newSetFromMap(new java.util.Hashtable<>());
    }

    @Override
    public boolean validate(Subject subject, CallbackHandler callbackHandler, String username,
                           String password) throws LoginException {
        callbackHandler.update(null, null);

        if (authenticatedUsers.contains(username)) {
            throw new LoginException("Authentication failed");
        }

        authenticatedUsers.add(username);

        return true;
    }
}