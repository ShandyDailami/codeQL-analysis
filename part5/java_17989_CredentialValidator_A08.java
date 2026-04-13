import javax.security.auth.callback.*;
import java.security.AccessControlException;
import java.security.GuardianInfo;
import java.security.GuardianInfo.QualifiedGuardianInfo;
import java.security.GuardianInfo.GuardianPermissionInfo;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class java_17989_CredentialValidator_A08 implements CallbackHandler {

    private Map<String, String> credentialMap = new HashMap<>();

    public java_17989_CredentialValidator_A08() {
        credentialMap.put("alice", "password123");
        credentialMap.put("bob", "password456");
    }

    @Override
    public Callback[] getCallerAuthenticationCallbacks() {
        return new Callback[]{new UsernamePasswordCallback()};
    }

    @Override
    public boolean validate(Callback[] callbacks) throws AccessControlException {
        UsernamePasswordCallback callback = (UsernamePasswordCallback) callbacks[0];

        String user = callback.getIdentifier();
        String password = callback.getPassword();

        return validateCredentials(user, password);
    }

    private boolean validateCredentials(String user, String password) {
        return password.equals(credentialMap.get(user));
    }

    public static void main(String[] args) {
        CallbackHandler handler = new CustomCredentialValidator();
        UsernamePasswordCallback callback = new UsernamePasswordCallback("alice", true);
        try {
            handler.validate(new Callback[]{callback});
        } catch (AccessControlException e) {
            System.out.println("Authentication failed due to: " + e.getMessage());
        }
    }
}