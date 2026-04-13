import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_04556_CredentialValidator_A07 implements LoginModule {

    private Credential credential;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Map<String, ?> options) throws LoginException {
        System.out.println("Entering CustomLoginModule initialize method...");
        Credential credential = new CustomCredential();
        this.credential = credential;
    }

    @Override
    public Credential getCredential(Subject subject) {
        return credential;
    }

    private class CustomCredential implements Credential {

        private String password;

        @Override
        public String getName() {
            return "CustomCredential";
        }

        @Override
        public String getPassword() {
            System.out.println("Entering getPassword method...");
            return password;
        }

        @Override
        public void setPassword(String password) {
            System.out.println("Entering setPassword method...");
            this.password = password;
        }

        @Override
        public boolean validate(Subject subject, Object credentials)
                throws LoginException {
            System.out.println("Entering validate method...");
            return validatePassword(credentials);
        }

        private boolean validatePassword(Object credentials) {
            String inputPassword = (String) credentials;
            return inputPassword != null && inputPassword.equals("password");
        }
    }
}