import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class java_07079_SessionManager_A07 implements SecurityManager {

    private Set<String> availableOperationNames = new HashSet<>(Arrays.asList("read", "write", "delete"));

    @Override
    public boolean isOperationPermitted(CallbackHandler callbackHandler, Subject subject, String operation) throws IOException, LoginException {
        return availableOperationNames.contains(operation);
    }

    public static void main(String[] args) throws LoginException, IOException {
        CustomSecurityManager securityManager = new CustomSecurityManager();

        // You can use this login call back to validate the user password
        CallbackHandler callbackHandler = new CallbackHandler() {
            @Override
            public boolean handle(Callback[] callbacks) throws IOException, LoginException {
                return true;
            }
        };

        // Call the login method
        Subject subject = Subject.getSubject(callbackHandler, securityManager, null);
        subject.getPrincipals().add(new LoginIdentifier("user", "password"));

        // Now you can perform operations
        if (securityManager.isOperationPermitted(callbackHandler, subject, "read")) {
            System.out.println("Read operation permitted");
        } else {
            System.out.println("Read operation not permitted");
        }

        if (securityManager.isOperationPermitted(callbackHandler, subject, "write")) {
            System.out.println("Write operation permitted");
        } else {
            System.out.println("Write operation not permitted");
        }
    }
}