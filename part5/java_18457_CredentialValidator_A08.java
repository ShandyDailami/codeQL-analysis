import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_18457_CredentialValidator_A08 implements LoginModule {

    private String username = "admin";
    private String password = "password";

    @Override
    public void initialize(CallbackHandler callbackHandler)
            throws UnsupportedCallbackException, LoginException {
        // Not implemented
    }

    @Override
    public Credential requestCredential(String arg0, String arg1) throws LoginException {
        return new UsernamePasswordCredential(arg0, arg1);
    }

    @Override
    public boolean validate(Credential credential) throws LoginException {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            return usernamePasswordCredential.getUsername().equals(username)
                    && usernamePasswordCredential.getPassword().equals(password);
        }
        return false;
    }

}