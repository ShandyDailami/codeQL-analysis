import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_30530_CredentialValidator_A03 implements CallbackHandler {
    private Map<String, String> credentialMap;

    public java_30530_CredentialValidator_A03() {
        this.credentialMap = new HashMap<>();
        this.credentialMap.put("alice", "password");
        this.credentialMap.put("bob", "password");
        this.credentialMap.put("charlie", "password");
    }

    @Override
    public String getPassword(String userName) {
        return credentialMap.get(userName);
    }

    @Override
    public void refresh() {
        // This method is not used in this example, but it's required by the CallbackHandler interface.
    }

    public boolean authenticate(String userName, String password) {
        String expectedPassword = this.getPassword(userName);
        if (expectedPassword == null) {
            throw new AccessControlException("No such user: " + userName);
        }
        return expectedPassword.equals(password);
    }

    public static void main(String[] args) {
        CustomCredentialValidator credentialValidator = new CustomCredentialValidator();

        // Testing the authenticate method
        try {
            boolean authenticated = credentialValidator.authenticate("alice", "password");
            if (authenticated) {
                System.out.println("User alice authenticated successfully!");
            } else {
                System.out.println("Failed to authenticate user alice!");
            }
        } catch (AccessControlException e) {
            System.out.println(e.getMessage());
        }
    }
}