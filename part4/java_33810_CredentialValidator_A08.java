import java.security.Principal;
import java.security.Credential;
import javax.security.auth.Subject;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.message.AuthException;

public class java_33810_CredentialValidator_A08 implements javax.security.auth.login.AppLoginModule {

    private CallbackHandler callbackHandler;
    private Subject subject;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, java.security.Principal principal) throws AuthException, IllegalStateException {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
    }

    @Override
    public boolean validate(Subject subject, Principal principal) throws AuthException {
        if (principal == null) {
            throw new AuthException("Principal cannot be null");
        }

        // Assume that the principal is a user name
        if (!(principal instanceof String)) {
            throw new AuthException("Principal must be a String");
        }

        String userName = (String) principal;

        // Assume that we have a user in our system with this name
        if (!checkUser(userName)) {
            throw new AuthException("User does not exist or password incorrect");
        }

        // If all checks pass, then return true
        return true;
    }

    private boolean checkUser(String userName) {
        // Add your actual login logic here
        // For this example, we'll just return true if the user name is "admin"
        return userName.equals("admin");
    }

    @Override
    public boolean commit() throws AuthException {
        return true;
    }

    @Override
    public void cleanup() throws AuthException {
    }
}