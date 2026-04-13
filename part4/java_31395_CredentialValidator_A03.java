import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlAction;
import java.security.AccessControlListener;
import java.security.AccessControlRegistry;
import java.security.GuaranteedAccessPermission;
import java.security.Permission;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

public class java_31395_CredentialValidator_A03 implements javax.security.auth.CredentialValidator {

    private List<String> validCredentials;

    public java_31395_CredentialValidator_A03() {
        this.validCredentials = new ArrayList<>();
        this.validCredentials.add("user1");
        this.validCredentials.add("user2");
    }

    @Override
    public String getCallerPrincipal() {
        return null;
    }

    @Override
    public List<String> getValidPrincipals(String callerPrincipal) {
        return validCredentials;
    }

    @Override
    public boolean validate(Subject subject, String callerPrincipal, List<? extends Permission> permissions,
            List<? extends ProtectionDomain> domains) {
        if (permissions.contains(new GuaranteedAccessPermission("use"))) {
            if (validCredentials.contains(callerPrincipal)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate(null, "user1", Arrays.asList(new GuaranteedAccessPermission("use")), Collections.emptyList()));
        System.out.println(validator.validate(null, "user3", Arrays.asList(new GuaranteedAccessPermission("use")), Collections.emptyList()));
    }
}