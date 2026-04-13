import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.CredentialException;
import java.security.GuaranteedAccessException;
import java.util.Arrays;

public class java_09232_CredentialValidator_A08 implements CallbackHandler {

    private static final String[] USERS = {"user1", "user2", "user3"};
    private static final String[] PASSWORDS = {"password1", "password2", "password3"};
    private static final String[] ROLES = {"ROLE_USER", "ROLE_ADMIN", "ROLE_SUPERUSER"};

    public boolean validate(String username, String password, String role) throws CredentialException, AccessControlException {
        if (!Arrays.asList(USERS).contains(username)) {
            throw new CredentialException("Unknown User");
        }

        if (!Arrays.asList(PASSWORDS).contains(password)) {
            throw new CredentialException("Unknown Password");
        }

        if (!Arrays.asList(ROLES).contains(role)) {
            throw new CredentialException("Unknown Role");
        }

        return true;
    }

    public void handle(Callback[] callbacks) throws CredentialException, UnsupportedCallbackException, AccessControlException {
        throw new UnsupportedCallbackException(null, "No supported callbacks");
    }

    public static void main(String[] args) throws AccessControlException {
        CredentialValidator credentialValidator = new CredentialValidator();
        AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                try {
                    credentialValidator.validate("user1", "password1", "ROLE_USER");
                    System.out.println("Successfully authenticated!");
                } catch (CredentialException e) {
                    e.printStackTrace();
                } catch (AccessControlException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }
}