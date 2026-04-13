import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.usernamepassword.UsernamePasswordCallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.spi.LoginModule;
import java.security.AccessControlContext;
import java.security.Guard;
import java.util.Arrays;

public class java_23544_CredentialValidator_A03 {

    private static final String[] USERS = {"user1", "user2", "user3"};
    private static final String[] PASSWORDS = {"password1", "password2", "password3"};

    public static class MyLoginModule implements LoginModule {

        private Subject subject;

        @Override
        public void initialize(Subject subject, CallbackHandler callbackHandler, AccessControlContext accessControlContext) {
            this.subject = subject;
        }

        @Override
        public boolean validate(Subject subject, String callerPrincipal, String password) {
            for (int i = 0; i < USERS.length; i++) {
                if (USERS[i].equals(callerPrincipal) && PASSWORDS[i].equals(password)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean getRequestedCredential(Subject subject) {
            return false;
        }

        @Override
        public boolean commit() {
            return true;
        }

        @Override
        public void cleanup(Subject subject) {

        }
    }

    public static void main(String[] args) throws Exception {
        LoginContext loginContext = new LoginContext("MyRealm", new MyLoginModule());
        loginContext.login();

        // If the credentials are valid, the loginContext is authenticated.
        if (loginContext.getAuthenticatedSubject() != null) {
            System.out.println("Authenticated!");
        } else {
            System.out.println("Failed to authenticate.");
        }
    }
}