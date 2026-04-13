import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;

public class java_14043_CredentialValidator_A07 implements CallbackHandler {

    private String username;
    private String password;

    @Override
    public void handle(Callback[] callbacks) throws AuthenticationException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernameCallback) {
                this.username = ((UsernameCallback) callback).getUsername();
            } else if (callback instanceof PasswordCallback) {
                this.password = ((PasswordCallback) callback).getPassword();
            }
        }
    }

    public boolean validate(Subject subject, String username, String password) {
        if (this.username != null && this.username.equals(username) && this.password != null && this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();

        // Replace with your actual callback handler
        CredentialCallbackHandler callbackHandler = new CredentialCallbackHandler(validator);

        // Replace with your actual callbacks array
        Callback[] callbacks = new Callback[]{new UsernameCallback("User"), new PasswordCallback("Password", "secret")};

        try {
            callbackHandler.handle(callbacks);
            System.out.println("Validation result: " + validator.validate(null, "User", "Password"));
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        } catch (UnsupportedCallbackException e) {
            System.out.println("Unsupported callback exception: " + e.getMessage());
        }
    }
}