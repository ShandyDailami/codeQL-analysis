import javax.security.auth.CredentialValidationResult;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.AppLoginModule;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_40360_CredentialValidator_A03 implements CredentialValidationResult.Status, CallbackHandler {
    private static final String[] VALID_USERS = {"user1", "user2", "user3"};

    @Override
    public CredentialValidationResult validate(Subject subject, UsernamePasswordCredential credential) {
        String username = credential.getUsername();
        if (isValid(username)) {
            return new CredentialValidationResult(username, "Success");
        } else {
            return new CredentialValidationResult(username, "Invalid credentials");
        }
    }

    private boolean isValid(String username) {
        for (String validUser : VALID_USERS) {
            if (validUser.equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public CredentialValidationResult validate(Subject subject, AppLoginModule module) {
        throw new UnsupportedCallbackException();
    }

    @Override
    public CredentialValidationResult validate(Subject subject, Callback callback) {
        throw new UnsupportedCallbackException();
    }

    @Override
    public CredentialValidationResult validate(Subject subject, String callerQualifiedName, Object password) {
        throw new UnsupportedCallbackException();
    }

    @Override
    public CredentialValidationResult validate(Subject subject, String[] usernames, String[] passwords, String callerQualifiedName) {
        throw new UnsupportedCallbackException();
    }

    public static void main(String[] args) {
        try {
            LoginContext loginContext = new LoginContext("MyRealm", new MyCallbackHandler());
            loginContext.login();
            System.out.println("Logged in as: " + loginContext.getSubject().getPrincipal());
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    private static class MyCallbackHandler implements CallbackHandler {
        @Override
        public CredentialValidationResult validate(Subject subject, UsernamePasswordCredential credential) {
            String username = credential.getUsername();
            if (isValid(username)) {
                return new CredentialValidationResult(username, "Success");
            } else {
                return new CredentialValidationResult(username, "Invalid credentials");
            }
        }
    }
}