// This is a basic credential validator example. It uses a simple username and password for authentication.

import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.security.AccessControlContext;
import java.security.GuaranteedAccessException;
import java.util.Arrays;

public class java_15181_CredentialValidator_A03 implements LoginModule {
    private String username = null;
    private char[] password = null;

    public String getPassword() {
        return new String(password);
    }

    public String getUsername() {
        return username;
    }

    public boolean validate(Subject subject, String password) {
        if (password != null) {
            this.password = password.toCharArray();
            return true;
        } else {
            return false;
        }
    }

    public boolean commit() throws GuaranteedAccessException {
        return true;
    }

    public void initialize(Subject subject, CallbackHandler callbackHandler, AccessControlContext accessControlContext) throws IOException, LoginException {
        // No initialization is needed for this example
    }

    public void cleanup(Subject subject, CallbackHandler callbackHandler, AccessControlContext accessControlContext) throws IOException, LoginException {
        // No cleanup is needed for this example
    }
}

// This is an example of how to use the CredentialValidator module.
public class CredentialValidatorExample {
    public static void main(String[] args) {
        try {
            Subject.login(new CredentialValidator(), new CallbackHandler() {
                public java_15181_CredentialValidator_A03(Callback[] callbacks) throws IOException, LoginException {
                    // No callbacks need to be handled
                }

                public void handle(Callback callback) throws IOException, LoginException {
                    // No callbacks need to be handled
                }
            });

            // This will print the username and password set in the CredentialValidator
            System.out.println("Username: " + ((CredentialValidator) Subject.getSubject().getPrincipal()).getUsername());
            System.out.println("Password: " + ((CredentialValidator) Subject.getSubject().getPrincipal()).getPassword());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}