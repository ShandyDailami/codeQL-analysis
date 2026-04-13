public class java_15672_CredentialValidator_A07 {

    public interface CredentialValidatorCallback {
        void onCredentialValidated(String username, String password);
        void onCredentialInvalidated();
    }

    private CredentialValidatorCallback callback;
    private String username;
    private String password;

    public java_15672_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setCallback(CredentialValidatorCallback callback) {
        this.callback = callback;
    }

    public void validateCredentials() {
        // This is a placeholder. In a real use case, you would typically
        // validate the credentials here using a secure method, such as a hashing
        // algorithm.
        if (username.equals("admin") && password.equals("password")) {
            if (callback != null) {
                callback.onCredentialValidated(username, password);
            }
        } else {
            if (callback != null) {
                callback.onCredentialInvalidated();
            }
        }
    }
}