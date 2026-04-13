import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.*;
import javax.security.auth.spi.*;

public class java_30531_CredentialValidator_A01 implements CallbackHandler, LoginModule {

    private Subject subject;
    private boolean validated;

    @Override
    public boolean validate(Subject subject, CallbackHandler callbackHandler)
            throws IllegalArgumentException, NoSuchAuthorizationInfoException,
            UnavailableException {
        this.subject = subject;
        this.validated = false;

        // Simulating legacy security operation
        String userId = subject.getPrincipal().toString();
        String password = "password";

        if (isPasswordValid(userId, password)) {
            this.validated = true;
        }

        return this.validated;
    }

    @Override
    public boolean login() throws LoginException {
        if (this.validated) {
            return true;
        } else {
            throw new LoginException("Invalid credentials");
        }
    }

    @Override
    public boolean abort(CallbackHandler callbackHandler) throws UnavailableException {
        if (this.validated) {
            return true;
        } else {
            throw new UnavailableException("Invalid credentials");
        }
    }

    private boolean isPasswordValid(String userId, String password) {
        // Implementation of checking password against userId
        // This is a very basic check, in real application, password should be hashed and compared with the hashed password
        return password.equals("password");
    }
}