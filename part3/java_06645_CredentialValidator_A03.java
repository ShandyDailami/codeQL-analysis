import javax.security.auth.Credential;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.PasswordChangeRequiredException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_06645_CredentialValidator_A03 implements CredentialValidationResult, Credential, CallbackHandler, Serializable {

    private boolean success;
    private Set<String> roles;

    public java_06645_CredentialValidator_A03(boolean success, String... roles) {
        this.success = success;
        this.roles = new HashSet<>(Arrays.asList(roles));
    }

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler) throws LoginException, IOException, UnsupportedCallbackException {
        if (success) {
            return this;
        } else {
            return null;
        }
    }

    @Override
    public Set<String> getGroups() {
        return this.roles;
    }

    @Override
    public boolean success() {
        return this.success;
    }

    @Override
    public void refresh() throws LoginException {
        // this method is not used in this case
    }

    public static void main(String[] args) {
        // For testing purpose, you can run this code
        CustomCredentialValidation credential = new CustomCredentialValidation(true, "ROLE_ADMIN");
        System.out.println(credential.getGroups());
    }
}