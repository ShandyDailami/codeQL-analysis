import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;

public class java_26327_CredentialValidator_A01 implements CallbackHandler {

    private PasswordChecker passwordChecker;

    public java_26327_CredentialValidator_A01(PasswordChecker passwordChecker) {
        this.passwordChecker = passwordChecker;
    }

    @Override
    public Credential validate(Callback callback) throws UnsupportedCallbackException {
        String username = callback.getRequest().getRequestedPrivilege().getName();
        String password = new String(callback.getCredential().getCredential(), "UTF-8");

        if (passwordChecker.isValidPassword(username, password)) {
            return new UsernamePasswordCredential(username, password.toCharArray());
        } else {
            throw new UnsupportedCallbackException(callback, "Invalid credentials for " + username);
        }
    }

    public static class PasswordChecker {
        public boolean isValidPassword(String username, String password) {
            // Implement your password check logic here.
            // For simplicity, we just check if the password is the same as the username.
            return password.equals(username);
        }
    }
}