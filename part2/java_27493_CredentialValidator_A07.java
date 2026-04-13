import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;

public class java_27493_CredentialValidator_A07 implements CallbackHandler {

    @Override
    public void handle(Callback[] callbacks) throws LoginException, UnsupportedCallbackException {
        Subject subject = new Subject();

        // Validate the username
        Callback[] usernameCallbacks = new Callback[1];
        usernameCallbacks[0] = new UsernameCallback("Username:");
        subject.getAuthenticationPrincipal().doAs(new ValidateUsername(usernameCallbacks));

        // Validate the password
        Callback[] passwordCallbacks = new Callback[1];
        passwordCallbacks[0] = new PasswordCallback("Password:", false);
        subject.getAuthenticationPrincipal().doAs(new ValidatePassword(passwordCallbacks));
    }

    public static void main(String[] args) throws LoginException {
        CredentialValidator validator = new CredentialValidator();
        validator.handle(new Callback[]{new UsernameCallback("Username:"), new PasswordCallback("Password:", false)});
    }
}

class UsernameCallback implements Callback {
    private String prompt;

    public java_27493_CredentialValidator_A07(String prompt) {
        this.prompt = prompt;
    }

    @Override
    public void setRequestedOP(String requestedOP) throws UnsupportedCallbackException {
        // Not used in this example
    }

    @Override
    public String getRequestedOP() {
        return null;
    }

    @Override
    public void verify() throws InvalidStateException {
        // Validate the username here, e.g. check against a database
    }

    @Override
    public void dispose(String input) {
        // Not used in this example
    }
}

class PasswordCallback implements Callback {
    private String prompt;

    public java_27493_CredentialValidator_A07(String prompt, boolean userInputs) {
        this.prompt = prompt;
    }

    @Override
    public void setRequestedOP(String requestedOP) throws UnsupportedCallbackException {
        // Not used in this example
    }

    @Override
    public String getRequestedOP() {
        return null;
    }

    @Override
    public void verify() throws InvalidStateException {
        // Validate the password here, e.g. compare to a stored hash
    }

    @Override
    public void dispose(String input) {
        // Not used in this example
    }
}