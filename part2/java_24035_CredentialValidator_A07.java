import java.security.InvalidParameterException;

public class java_24035_CredentialValidator_A07 {

    public interface CredentialValidatorCallback {
        void onValidated(String userName);
        void onInvalidated(String userName);
    }

    private CredentialValidatorCallback callback;

    public java_24035_CredentialValidator_A07(CredentialValidatorCallback callback) {
        if (callback == null) {
            throw new InvalidParameterException("Callback is null");
        }
        this.callback = callback;
    }

    public void validateCredentials(String userName, String password) {
        if (userName == null || password == null) {
            callback.onInvalidated(userName);
            return;
        }

        // Here we're using a simplistic approach. In reality, you'd have a real authentication system
        // Check if the user name and password match a known user and their password.
        // For the sake of simplicity, we'll just check if they're "admin"
        if ("admin".equals(userName) && "password".equals(password)) {
            callback.onValidated(userName);
        } else {
            callback.onInvalidated(userName);
        }
    }
}